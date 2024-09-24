package com.data.springdata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "wards")
public class Ward {
    @Id
    private String id;
    private String departmentId;
    private Integer number;
    private Integer bedCount;
    private String supervisorId; // Reference to Employee (nurse)
}
