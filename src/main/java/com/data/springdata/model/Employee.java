package com.data.springdata.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String employeeNumber;
    private String surname;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String role; // "DOCTOR" or "NURSE"
    private String speciality; // for doctors
    private String rotation; // for nurses
    private Double salary; // for nurses
}
