package com.thanhpt.fairytale.Item;

public class User {
    private String email;
    private String password;
    private String platform;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.platform = "mobile";
    }
}
