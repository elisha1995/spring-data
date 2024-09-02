package com.data.springdata.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfBeds;

    @ManyToOne
    @JoinColumn(name = "department_code")
    private Department department;

    @OneToOne
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;
}
