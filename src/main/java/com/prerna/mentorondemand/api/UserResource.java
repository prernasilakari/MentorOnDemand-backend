package com.prerna.mentorondemand.api;

import com.prerna.mentorondemand.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserResource  {
    @PostMapping("/user")
    ResponseEntity<User> createUser(@RequestBody User user);

    @GetMapping("/user/{userId}")
    ResponseEntity<User> getUser(@PathVariable int userId);

    @GetMapping("/user")
    ResponseEntity<List<User>> getAllUser();

    @PutMapping("/user/{userId}")
    ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user);

    @DeleteMapping("/user/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable int userId);

}
