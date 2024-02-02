package com.prometheus.vord.service;

import com.prometheus.vord.DTO.*;
import com.prometheus.vord.common.ApiResponse;
import com.prometheus.vord.domain.entity.Song;
import com.prometheus.vord.domain.entity.SongList;
import com.prometheus.vord.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final GPTService gptService;
    private final UserRepository userRepository;
    private final SongRepository songRepository;
    private final SongListRepository songListRepository;
    private final SongStyleRepository songStyleRepository;
    private final RecommendSongRepository recommendSongRepository;
    public ApiResponse<ResponseUserInfo> getUserInfo(long id) throws Exception {
        try{
            return ApiResponse.success(ResponseUserInfo.of(userRepository.findById(id).orElseThrow()));
        }
        catch (Exception e){
            throw new Exception("user 정보를 가져오는 데 실패하였습니다.");
        }
    }

    public ApiResponse<List<ResponseSongList>> getSongList() throws Exception{
        try {
            return ApiResponse.success(
                    songListRepository.findByUserId(userRepository.findById(1L).orElseThrow()).stream().map(ResponseSongList::of).toList()
            );
        }
        catch (Exception e){
            throw new Exception("음악 리스트를 가져오는 데 실패하였습니다.");
        }
    }

    public ApiResponse<List<ResponseSongStyle>> getSongStyleList(long id) throws Exception {
        try{
            return ApiResponse.success(
                    songStyleRepository.findByUserId(userRepository.findById(id).orElseThrow()).stream().map(ResponseSongStyle::of).toList()
            );
        }
        catch (Exception e){
            throw new Exception("음악 취향을 가져오는데 실패하였습니다.");
        }
    }
    @Transactional
    public ApiResponse<String> addSongStyle(PostSongStyleDTO postSongStyleDTO) throws Exception {
        try {
            for (Long id : postSongStyleDTO.getStyleIdList()) {
                songStyleRepository.findById(id).orElseThrow().updateStyle(userRepository.findById(postSongStyleDTO.getUserId()).orElseThrow());
            }
            return ApiResponse.success("");
        }catch (Exception e){
            throw new Exception("노래 취향 추가 실패하였습니다.");
        }
    }

    public ApiResponse<SongInfoDTO> getSong(long id) throws Exception {
        try {
            return ApiResponse.success(SongInfoDTO.of(songRepository.findById(id).orElseThrow()));
        }catch (Exception e){
            throw new Exception("노래 재생에 실패하였습니다.");
        }
    }

    public ApiResponse<List<SongInfoDTO>> getSongs(long id) {
        return ApiResponse.success(songRepository.findBySongList(songListRepository.findById(id).orElseThrow()).stream().map(SongInfoDTO::of).toList());
    }

    public ApiResponse<List<ResponsePlaylistSituation>> getSituationSongs(int type) {
        return ApiResponse.success(
                recommendSongRepository.findByType(type).stream().map(ResponsePlaylistSituation::of).toList());
    }
    @Transactional
    public ApiResponse<String> makePlaylist(PostPlayListDTO postPlayListDTO) {
        String situation = "";
        switch (postPlayListDTO.getType()) {
            case 1 -> situation = "잠이 오지 않을 때";
            case 2 -> situation = "여행갈 때";
            case 3 -> situation = "썸탈 때";
            case 4 -> situation = "비올 때";
        }
        String name = situation + " " + postPlayListDTO.getSinger() + "s'Crap";
        SongList songList = songListRepository.save(
                SongList.builder()
                        .name(name)
                        .coverImage("")
                        .userId(userRepository.findById(1L).orElseThrow())
                        .type(postPlayListDTO.getType())
                        .build()
        );
        for(PostPlayListDTO.SingInfo singInfo: postPlayListDTO.getSingList()){
            songRepository.save(
                    Song.builder()
                            .singer(singInfo.getOriginalSinger())
                            .name(singInfo.getName())
                            .fileLocation("/home/ubuntu/"+postPlayListDTO.getSinger()+"_"+singInfo.getName())
                            .originalSinger(singInfo.getOriginalSinger())
                            .songList(songList)
                            .build()
            );
        }
        return ApiResponse.success("success");
    }

    public ApiResponse<List<String>> generateImage(String singer) throws Exception {

        try {
            List<String> list = gptService.generatePicture("picture of " + singer + "'s happy songs");
            return ApiResponse.success(list);
        }catch (Exception e){
            throw new Exception("GPT error!");
        }
    }
    @Transactional
    public ApiResponse<String> selectImage(RequestSelectImageDTO requestSelectImageDTO) throws Exception {
        try {
            songListRepository.findById(requestSelectImageDTO.getId()).orElseThrow().updateImage(requestSelectImageDTO.getImageUrl());
            return ApiResponse.success("");
        }
        catch (Exception e){
            throw new Exception("이미지를 선택하는 데 오류가 발생하였습니다.");
        }
    }
}
