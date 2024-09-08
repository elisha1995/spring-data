package com.data.springdata.services;

import com.data.springdata.models.Patient;
import com.data.springdata.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findByDiagnosis(String diagnosis) {
        return patientRepository.findByDiagnosis(diagnosis);
    }

    public List<Patient> findByWardId(int wardId) {
        return patientRepository.findByWardId(wardId);
    }

    public List<Patient> findByDoctorEmployeeNumber(int doctorEmployeeNumber) {
        return patientRepository.findByDoctorEmployeeNumber(doctorEmployeeNumber);
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deleteById(Integer id) {
        patientRepository.deleteById(id);
    }
}
