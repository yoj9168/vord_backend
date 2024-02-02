package com.prometheus.vord.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RequestSelectImageDTO {
    private long id;
    private String imageUrl;
}
