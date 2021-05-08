package com.prerna.mentorondemand.impl;

import com.prerna.mentorondemand.api.UserResource;
import com.prerna.mentorondemand.model.User;
import com.prerna.mentorondemand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResourceImpl implements UserResource {


    @Autowired
    UserService userService;

    /**
     * Adding a new User
     *
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<User> createUser(User user) {
        User createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * getting User by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<User> getUser(int userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * getting all the User
     *
     * @return
     */
    @Override
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getUserList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Updating User by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<User> updateUser(int userId, User user) {
        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    /**
     * delete user by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<Void> deleteUser(int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
