package com.prerna.mentorondemand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String fullname;
    private String email;
    private Long mobile;
    private String description;
    private String expertise;

}
