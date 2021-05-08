package com.prerna.mentorondemand.repository;

import com.prerna.mentorondemand.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findById(int id);

}
