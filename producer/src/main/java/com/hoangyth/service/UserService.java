package com.hoangyth.service;

import com.hoangyth.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> getUser(String userId);

    List<User> getUsers();

    User createUser();
}
