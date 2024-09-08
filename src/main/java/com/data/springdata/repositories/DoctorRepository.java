package com.data.springdata.repositories;

import com.data.springdata.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySpeciality(String speciality);
    Doctor findByEmployeeNumber(int employeeNumber);
}
