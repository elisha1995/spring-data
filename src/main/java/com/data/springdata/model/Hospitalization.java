package com.data.springdata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "hospitalizations")
public class Hospitalization {
    @Id
    private String id;
    private String patientId;
    private String wardId;
    private Integer bedNumber;
    private String diagnosis;
    private String doctorId;
}
