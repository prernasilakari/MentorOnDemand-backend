package com.prerna.mentorondemand.impl;

import com.prerna.mentorondemand.api.MentorResource;
import com.prerna.mentorondemand.model.Mentor;
import com.prerna.mentorondemand.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MentorResourceImpl implements MentorResource {


    @Autowired
    MentorService mentorService;

    /**
     * Adding a new Mentor
     *
     * @param mentor
     * @return
     */
    @Override
    public ResponseEntity<Mentor> createMentor(Mentor mentor) {
        Mentor createdMentor = mentorService.addMentor(mentor);
        return new ResponseEntity<>(createdMentor, HttpStatus.CREATED);
    }

    /**
     * getting Mentor by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<Mentor> getMentor(int userId) {
        Mentor mentor = mentorService.getMentor(userId);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    /**
     * getting all the Mentor
     *
     * @return
     */
    @Override
    public ResponseEntity<List<Mentor>> getAllMentor() {
        List<Mentor> mentor = mentorService.getMentorList();
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    /**
     * Updating Mentor by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<Mentor> updateMentor(int userId, Mentor mentor) {
        Mentor updatedMentor = mentorService.updateMentor(userId, mentor);
        return new ResponseEntity<>(updatedMentor, HttpStatus.OK);

    }

    /**
     * delete admin by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<Void> deleteMentor(int userId) {
        mentorService.deleteMentor(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
