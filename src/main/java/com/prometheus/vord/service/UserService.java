package com.prometheus.vord.service;

import com.prometheus.vord.DTO.PostSongStyleDTO;
import com.prometheus.vord.DTO.ResponseSongList;
import com.prometheus.vord.DTO.ResponseSongStyle;
import com.prometheus.vord.DTO.ResponseUserInfo;
import com.prometheus.vord.common.ApiResponse;
import com.prometheus.vord.domain.entity.SongList;
import com.prometheus.vord.domain.entity.SongStyle;
import com.prometheus.vord.domain.entity.User;
import com.prometheus.vord.repository.SongListRepository;
import com.prometheus.vord.repository.SongStyleRepository;
import com.prometheus.vord.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SongListRepository songListRepository;
    private final SongStyleRepository songStyleRepository;
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
    public ApiResponse<String> addSongStyle(PostSongStyleDTO postSongStyleDTO) {
        for(Long i:postSongStyleDTO.getStyleIdList()){
            songStyleRepository.findById(i).orElseThrow().updateStyle(userRepository.findById(postSongStyleDTO.getUserId()).orElseThrow());
        }
        return ApiResponse.success("");
    }

}
