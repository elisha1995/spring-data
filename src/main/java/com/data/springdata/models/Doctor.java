package com.data.springdata.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Doctor extends Employee {
    private String speciality;
}
