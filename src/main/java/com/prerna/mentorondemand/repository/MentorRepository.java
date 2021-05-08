package com.prerna.mentorondemand.repository;

import com.prerna.mentorondemand.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {
    Mentor findById(int id);
}
