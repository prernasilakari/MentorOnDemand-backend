package com.prerna.mentorondemand.service;

import com.prerna.mentorondemand.model.User;
import com.prerna.mentorondemand.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        User newUser = userRepository.save(user);
        log.info("User is created");
        return newUser;
    }

    public User getUser(int userId) {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        return user;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User updateUser(int userId, User user) {
        User existingUser = getUser(userId);
        if (existingUser != null) {
            if (user.getUsername() != null) existingUser.setUsername(user.getUsername());
            if (user.getEmail() != null) existingUser.setEmail(user.getEmail());
            if (user.getMobile() != null) existingUser.setMobile(user.getMobile());
        } else throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        existingUser = userRepository.save(existingUser);
        log.info("User is updated");
        return existingUser;
    }

    public void deleteUser(int userId) {
        User user = getUser(userId);
        if (user == null)
            throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        userRepository.deleteById(userId);
        log.info("User is deleted");
    }

}
