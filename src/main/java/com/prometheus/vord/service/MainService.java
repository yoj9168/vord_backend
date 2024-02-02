package com.prometheus.vord.service;

import com.prometheus.vord.DTO.ResponseSongStyle;
import com.prometheus.vord.common.ApiResponse;
import com.prometheus.vord.repository.SongStyleRepository;
import com.prometheus.vord.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MainService {
    private final SongStyleRepository songStyleRepository;
    private final UserRepository userRepository;

    public ApiResponse<List<ResponseSongStyle>> getSongStyleList() throws Exception {

        try{
            return ApiResponse.success(
                    songStyleRepository.findByUserId(userRepository.findById(100L).orElseThrow()).stream().map(ResponseSongStyle::of).toList()
            );
        }
        catch (Exception e){
            throw new Exception("음악 취향을 가져오는데 실패하였습니다.");
        }
    }
}
