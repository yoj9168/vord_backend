package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.RecommendSong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponsePlaylistSituation {
    private String name;
    private String singer;
    private String type;
    private byte[] image;

    public static ResponsePlaylistSituation of(RecommendSong recommendSong) {
        String situation = "";
        switch (recommendSong.getType()) {
            case 1 -> situation = "잠이 오지 않을 때";
            case 2 -> situation = "여행갈 때";
            case 3 -> situation = "썸탈 때";
            case 4 -> situation = "비올 때";
        }

        return new ResponsePlaylistSituation(recommendSong.getName(), recommendSong.getSinger(), situation, recommendSong.getImage());
    }

}
