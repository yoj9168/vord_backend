package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostSongStyleDTO {
    private Long userId;
    private List<Long> styleIdList;
}
