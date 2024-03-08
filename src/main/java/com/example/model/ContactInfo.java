package com.example.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
public class ContactInfo{
    private String phone;
    private String email;
    private String guardianPhoneNo;

}
