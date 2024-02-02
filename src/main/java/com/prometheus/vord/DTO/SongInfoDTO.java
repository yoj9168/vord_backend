package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SongInfoDTO {
    private String singer;
    private String name;
    private String fileLocation;

    public static SongInfoDTO of(Song song){
        return new SongInfoDTO(song.getSinger(), song.getName(), song.getFileLocation());
    }
}
