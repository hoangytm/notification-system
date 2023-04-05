package com.hoangyth.service;

import com.hoangyth.model.User;
import com.hoangyth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(String userId) {
        Optional<User> user = userRepository.findUserById(userId);
        try {
            System.out.println("thread id: " + Thread.currentThread().getId());
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        Optional<User> user = userRepository.findUserByUserName(userName);
        if (user.isPresent()) {
            System.out.println("=======> find out the user" +Thread.currentThread().getName());
            try {
                Thread.sleep(15000);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            user.get().setUserName("hoang123123");
            userRepository.save(user.get());
        } else {
            System.out.println("can not find out user"+ Thread.currentThread().getName());
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
