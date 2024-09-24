package com.data.springdata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "departments")
public class Department {
    @Id
    private String id;
    private String code;
    private String name;
    private String building;
    private String directorId; // Reference to Employee (doctor)
}
