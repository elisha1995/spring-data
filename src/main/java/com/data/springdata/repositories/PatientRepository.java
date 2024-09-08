package com.data.springdata.repositories;

import com.data.springdata.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDiagnosis(String diagnosis);
    List<Patient> findByWardId(int wardId);
    List<Patient> findByDoctorEmployeeNumber(int doctorEmployeeNumber);
}
