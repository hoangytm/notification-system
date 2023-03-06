package com.hoangyth.service;

import com.hoangyth.model.User;
import com.hoangyth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
