package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.SongList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseSongList {
    private long id;
    private String singer;
    private String fileLocation;
    private String coverImage;

    public static ResponseSongList of(SongList songList){
        return new ResponseSongList(songList.getId(), songList.getSinger(), songList.getFileLocation(), songList.getCoverImage());
    }
}
