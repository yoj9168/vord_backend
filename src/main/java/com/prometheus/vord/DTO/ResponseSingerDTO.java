package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.Singer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseSingerDTO {
    private String name;
    private String image;

    public static ResponseSingerDTO of(Singer singer) {
        return new ResponseSingerDTO(singer.getName(), singer.getImage());
    }
}
