package com.prerna.mentorondemand.repository;

import com.prerna.mentorondemand.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
}
