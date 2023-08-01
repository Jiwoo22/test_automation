package com.solvd.carina.demo.utils;

import com.zebrunner.carina.utils.R;

public class UserService {

    private User user;

    public UserService() {
        this.user = new User();
    }

    public User getUser() {
        this.user.setEmail(R.TESTDATA.get("email"));
        this.user.setPassword(R.TESTDATA.get("password"));
        return user;
    }

    public User getUserWithInvalidEmail() {
        this.user.setEmail(R.TESTDATA.get("invalid_email"));
        this.user.setPassword(R.TESTDATA.get("password"));
        return user;
    }

    public User getUserWithInvalidPassword() {
        this.user.setEmail(R.TESTDATA.get("email"));
        this.user.setPassword(R.TESTDATA.get("invalid_password"));
        return user;
    }
}
