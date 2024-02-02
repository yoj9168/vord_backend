package com.prometheus.vord.controller;

import com.prometheus.vord.DTO.*;
import com.prometheus.vord.common.ApiResponse;
import com.prometheus.vord.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    //이름, 나이, 프로필 사진 주기
    @GetMapping("/{id}")
    public ApiResponse<ResponseUserInfo> getUserInfo(@PathVariable("id") long id) throws Exception{
        return userService.getUserInfo(id);
    }
    //사용자가 가지고 있는 플레이리스트들 다 보여주기
    @GetMapping("/playlist")
    public ApiResponse<List<ResponseSongList>> getSongLists() throws Exception{
        return userService.getSongList();
    }
    //플레이리스트 선택시에 곡들 다 보여주기
    @GetMapping("/playlist/{id}")
    public ApiResponse<List<SongInfoDTO>> getSongs(@PathVariable("id") long id) throws Exception{
        return userService.getSongs(id);
    }

    //나만의 플레이스트 만들기
    @PostMapping("/playlist")
    public ApiResponse<String> makePlaylist(@RequestBody PostPlayListDTO postPlayListDTO) throws Exception{
        return userService.makePlaylist(postPlayListDTO);
    }

    //플레이리스트 상황별로 곡 주기
    @GetMapping("/playlist/situation/{type}")
    public ApiResponse<List<ResponsePlaylistSituation>> getSituationSongs(@PathVariable("type") int type) throws Exception{
        return userService.getSituationSongs(type);
    }

    //음악 취향 주기
    @GetMapping("/song/style/{id}")
    public ApiResponse<List<ResponseSongStyle>> getSongStyleList(@PathVariable("id") long id) throws Exception{
        return userService.getSongStyleList(id);
    }

    //음악 선택해서 듣기
    @GetMapping("/song/{id}")
    public ApiResponse<SongInfoDTO> getSong(@PathVariable("id") long id) throws Exception{
        return userService.getSong(id);
    }
    //음악 취향 추가하기
//    {"userId":"1",
//     "styleIdList":[3,4]}
//    항상 userId 는 1
//    styleIdList 는 http://218.156.133.227:8080/api/song/list에서 확인
    @PostMapping("/song/style")
    public ApiResponse<String> addSongStyle(@RequestBody PostSongStyleDTO postSongStyleDTO) throws Exception{
        return userService.addSongStyle(postSongStyleDTO);
    }

    //플레이리스트 커버 gpt 3개 보내줌
    @PostMapping("/playlist/cover")
    public ApiResponse<List<String>> generateImage(@RequestBody RequestCoverImageDTO requestCoverImageDTO) throws Exception {
        return userService.generateImage(requestCoverImageDTO.getSinger());
    }

    //플레이리스트 커버 선택
    @PostMapping("/playlist/cover/select")
    public ApiResponse<String> selectImage(@RequestBody RequestSelectImageDTO requestSelectImageDTO) throws Exception {
        return userService.selectImage(requestSelectImageDTO);
    }

}
