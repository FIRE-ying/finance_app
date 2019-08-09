package com.qf.vo;

import lombok.Data;

@Data
public class UserVO {

    private String username;
    private String password;
    private String phone;

    public UserVO(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public UserVO() {
    }
}
