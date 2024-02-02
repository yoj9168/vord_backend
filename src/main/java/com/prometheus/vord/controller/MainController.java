package com.prometheus.vord.controller;

import com.prometheus.vord.DTO.ResponseSongStyle;
import com.prometheus.vord.common.ApiResponse;
import com.prometheus.vord.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
