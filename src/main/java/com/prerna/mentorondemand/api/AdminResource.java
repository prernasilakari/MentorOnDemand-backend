package com.prerna.mentorondemand.api;

import com.prerna.mentorondemand.model.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AdminResource {

    @PostMapping("/")
    ResponseEntity<Admin> createAdmin(@RequestBody Admin admin);

    @GetMapping("/{userId}")
    ResponseEntity<Admin> getAdmin(@PathVariable int userId);

    @GetMapping("/")
    ResponseEntity<List<Admin>> getAllAdmin();

    @PutMapping("/{userId}")
    ResponseEntity<Admin> updateAdmin(@PathVariable int userId, @RequestBody Admin admin);

    @DeleteMapping("/{userId}")
    ResponseEntity<Void> deleteAdmin(@PathVariable int userId);

}
