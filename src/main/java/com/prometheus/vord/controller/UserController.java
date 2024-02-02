package com.prometheus.vord.controller;

import com.prometheus.vord.DTO.PostSongStyleDTO;
import com.prometheus.vord.DTO.ResponseSongList;
import com.prometheus.vord.DTO.ResponseSongStyle;
import com.prometheus.vord.DTO.ResponseUserInfo;
import com.prometheus.vord.common.ApiResponse;
import com.prometheus.vord.domain.entity.SongList;
import com.prometheus.vord.service.UserService;
import lombok.RequiredArgsConstructor;
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
    //음악 리스트 주기
    @GetMapping("/song/list")
    public ApiResponse<List<ResponseSongList>> getSongList() throws Exception{
        return userService.getSongList();
    }
    //음악 취향 주기
    @GetMapping("/song/style/{id}")
    public ApiResponse<List<ResponseSongStyle>> getSongStyleList(@PathVariable("id") long id) throws Exception{
        return userService.getSongStyleList(id);
    }

    //음악 선택해서 듣기
    public ApiResponse<>
    //음악 취향 추가하기
//    {"userId":"1",
//     "styleIdList":[3,4]}
//    항상 userId 는 1
//    styleIdList 는 http://218.156.133.227/:8080/api/song/list에서 확인
    @PostMapping("/song/style")
    public ApiResponse<String> addSongStyle(@RequestBody PostSongStyleDTO postSongStyleDTO) throws Exception{
        return userService.addSongStyle(postSongStyleDTO);
    }
}
