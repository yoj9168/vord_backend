package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.Song;
import com.prometheus.vord.domain.entity.SongList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseSongList {
    private long id;
    private String playlistName;

    public static ResponseSongList of(SongList songlist){
        return new ResponseSongList(songlist.getId(), songlist.getName());
    }
}
