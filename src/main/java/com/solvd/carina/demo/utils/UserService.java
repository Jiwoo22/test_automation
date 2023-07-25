package com.solvd.carina.demo.utils;

public class UserService {

    private User user;

    public UserService(String email, String password) {
        this.user = new User(email, password);
    }

    public User getUser() {
        return user;
    }
}
