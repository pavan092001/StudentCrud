package com.example.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    @Embedded
    private ContactInfo contactInfo;
    private Date enrollmentDate;
}
