package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.SongStyle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseSongStyle {
    private long id;
    private String style;

    public static ResponseSongStyle of(SongStyle songStyle){
        return new ResponseSongStyle(songStyle.getId(), songStyle.getStyle());
    }
}
