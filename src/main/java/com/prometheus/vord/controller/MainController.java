package com.prometheus.vord.controller;

import com.prometheus.vord.DTO.ResponseSingerDTO;
import com.prometheus.vord.DTO.ResponseSongStyle;
import com.prometheus.vord.common.ApiResponse;
import com.prometheus.vord.service.GPTService;
import com.prometheus.vord.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {
    private final MainService mainService;

    //선택안된 음악 취향 주기
    @GetMapping("/song/list")
    public ApiResponse<List<ResponseSongStyle>> getSongStyleList() throws Exception{
        return mainService.getSongStyleList();
    }
    //가수 리스트 주기
    @GetMapping("/singer/list")
    public ApiResponse<List<ResponseSingerDTO>> getSingerInfo() throws Exception{
        return mainService.getSingerInfo();
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
