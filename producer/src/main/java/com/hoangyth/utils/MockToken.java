package com.hoangyth.utils;

import com.hoangyth.model.User;

public class MockToken {
    public static User getAdmin() {
        return new User("1", "admin");
    }

    public static User getNormalUser() {
        return new User("2", "normal");
    }
}
