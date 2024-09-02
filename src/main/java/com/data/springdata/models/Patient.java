package com.data.springdata.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientNumber;
    private String name;
    private String surname;
    private String address;
    private String telephoneNumber;
    private int bedNumber;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
