package com.data.springdata.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@Data
@RedisHash("employee")
public class RedisEmployee implements Serializable {
    private String id;
    private String employeeNumber;
    private String surname;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String role;
    private String speciality;
    private String rotation;

    public RedisEmployee() {}

    public RedisEmployee(String id, String employeeNumber, String surname, String firstName,
                         String address, String phoneNumber, String role,
                         String speciality, String rotation) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.speciality = speciality;
        this.rotation = rotation;
    }

}
