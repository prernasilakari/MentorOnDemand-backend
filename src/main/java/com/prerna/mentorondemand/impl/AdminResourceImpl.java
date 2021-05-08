package com.prerna.mentorondemand.impl;

import com.prerna.mentorondemand.api.AdminResource;
import com.prerna.mentorondemand.model.Admin;
import com.prerna.mentorondemand.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminResourceImpl implements AdminResource {

    @Autowired
    AdminService adminService;

    /**
     * Adding a new admin
     *
     * @param admin
     * @return
     */
    @Override
    public ResponseEntity<Admin> createAdmin(Admin admin) {
        adminService.addAdmin(admin);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    /**
     * getting admin by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<Admin> getAdmin(int userId) {
        Admin admin = adminService.getAdmin(userId);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    /**
     * getting all the admin
     *
     * @return
     */
    @Override
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> admin = adminService.getAdminList();
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    /**
     * Updating admin by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<Admin> updateAdmin(int userId, Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(userId, admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);

    }

    /**
     * delete admin by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<Void> deleteAdmin(int userId) {
        adminService.deleteAdmin(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
