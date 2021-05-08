package com.prerna.mentorondemand.service;

import com.prerna.mentorondemand.model.Admin;
import com.prerna.mentorondemand.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Admin addAdmin(Admin admin) {
        Admin newAdmin = adminRepository.save(admin);
        log.info("User is created");
        return newAdmin;
    }

    public Admin getAdmin(int userId) {
        Admin admin = adminRepository.findById(userId);
        if (admin == null)
            throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        return admin;
    }

    public List<Admin> getAdminList() {
        return adminRepository.findAll();
    }

    public Admin updateAdmin(int userId, Admin admin) {
        Admin existingUser = getAdmin(userId);
        if (existingUser != null) {
            if (admin.getUsername() != null) existingUser.setUsername(admin.getUsername());
            if (admin.getEmail() != null) existingUser.setEmail(admin.getEmail());
            if (admin.getMobile() != null) existingUser.setMobile(admin.getMobile());
        } else throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        existingUser = adminRepository.save(existingUser);
        log.info("User is updated");
        return existingUser;
    }

    public void deleteAdmin(int userId) {
        Admin admin = getAdmin(userId);
        if (admin == null)
            throw new NullPointerException(String.format("User not fount for userId: %s", userId));
        adminRepository.deleteById(userId);
        log.info("User is deleted");
    }
}