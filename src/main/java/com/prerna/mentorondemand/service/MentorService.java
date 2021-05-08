package com.prerna.mentorondemand.service;

import com.prerna.mentorondemand.model.Mentor;
import com.prerna.mentorondemand.repository.MentorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MentorService {


    @Autowired
    MentorRepository mentorRepository;

    public Mentor addMentor(Mentor mentor) {
        Mentor newMentor = mentorRepository.save(mentor);
        log.info("User is created");
        return newMentor;
    }

    public Mentor getMentor(int userId) {
        Mentor mentor = mentorRepository.findById(userId);
        if (mentor == null)
            throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        return mentor;
    }

    public List<Mentor> getMentorList() {
        return mentorRepository.findAll();
    }

    public Mentor updateMentor(int userId, Mentor mentor) {
        Mentor existingUser = getMentor(userId);
        if (existingUser != null) {
            if (mentor.getUsername() != null) existingUser.setUsername(mentor.getUsername());
            if (mentor.getEmail() != null) existingUser.setEmail(mentor.getEmail());
            if (mentor.getMobile() != null) existingUser.setMobile(mentor.getMobile());
        } else throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        existingUser = mentorRepository.save(existingUser);
        log.info("User is updated");
        return existingUser;
    }

    public void deleteMentor(int userId) {
        Mentor mentor = getMentor(userId);
        if (mentor == null)
            throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        mentorRepository.deleteById(userId);
        log.info("User is deleted");
    }

}
