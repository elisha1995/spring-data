package com.data.springdata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String patientNumber;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
}
