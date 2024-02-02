package com.prometheus.vord.service;

import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.Image;
import com.theokanning.openai.service.OpenAiService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GPTService {

    @Resource(name = "getOpenAiService")
    private final OpenAiService openAiService;

    public List<String> generatePicture(String prompt) {
        CreateImageRequest createImageRequest = CreateImageRequest.builder()
                .prompt(prompt)
                .size("512x512")
                .n(3)
                .build();
        List<String> list = new ArrayList<>();
        for(Image i : openAiService.createImage(createImageRequest).getData()){
            list.add(i.getUrl());
        }
        return list;
    }
}
