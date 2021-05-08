package com.prerna.mentorondemand.api;

import com.prerna.mentorondemand.model.Mentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MentorResource {
    @PostMapping("/mentor")
    ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentor);

    @GetMapping("/mentor/{userId}")
    ResponseEntity<Mentor> getMentor(@PathVariable int userId);

    @GetMapping("/mentor")
    ResponseEntity<List<Mentor>> getAllMentor();

    @PutMapping("/mentor/{userId}")
    ResponseEntity<Mentor> updateMentor(@PathVariable int userId, @RequestBody Mentor mentor);

    @DeleteMapping("/mentor/{userId}")
    ResponseEntity<Void> deleteMentor(@PathVariable int userId);

}
