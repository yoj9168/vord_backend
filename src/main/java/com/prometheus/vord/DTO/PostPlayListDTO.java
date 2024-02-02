package com.prometheus.vord.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostPlayListDTO {
    private String singer;

    private List<SingInfo> singList;

    private int type;
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class SingInfo{
        private String originalSinger;
        private String name;
    }

}
