package com.data.springdata.services;

import com.data.springdata.models.Doctor;
import com.data.springdata.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public List<Doctor> findBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }

    public Doctor findByEmployeeNumber(int employeeNumber) {
        return doctorRepository.findByEmployeeNumber(employeeNumber);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteById(Integer id) {
        doctorRepository.deleteById(id);
    }
}
