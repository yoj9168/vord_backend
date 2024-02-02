package com.prometheus.vord.DTO;

import com.prometheus.vord.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserInfo {
    private String name;
    private int age;
    private String profileImage;

    public static ResponseUserInfo of(User user){
        return new ResponseUserInfo(user.getName(), user.getAge(), user.getProfileImage());
    }
}
