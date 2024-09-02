package com.data.springdata.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Nurse extends Employee {
    private String rotation;
    private double salary;

    @OneToOne(mappedBy = "supervisor")
    private Ward ward;
}
