package com.example.request;

import com.example.model.ContactInfo;
import jakarta.persistence.Embedded;
import lombok.Data;

import java.util.Date;

@Data
public class StudentRequest {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    @Embedded
    private ContactInfo contactInfo;
    private Date enrollmentDate;
}
