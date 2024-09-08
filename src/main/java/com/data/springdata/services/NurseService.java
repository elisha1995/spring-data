package com.data.springdata.services;

import com.data.springdata.models.Nurse;
import com.data.springdata.models.Ward;
import com.data.springdata.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {
    @Autowired
    private NurseRepository nurseRepository;

    public List<Nurse> findAll() {
        return nurseRepository.findAll();
    }

    public Optional<Nurse> findById(Integer id) {
        return nurseRepository.findById(id);
    }

    public List<Nurse> findByRotation(String rotation) {
        return nurseRepository.findByRotation(rotation);
    }

    public List<Nurse> findBySalaryGreaterThan(double salary) {
        return nurseRepository.findBySalaryGreaterThan(salary);
    }

    public Nurse findByWard(Ward ward) {
        return nurseRepository.findByWard(ward);
    }

    public Nurse save(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public void deleteById(Integer id) {
        nurseRepository.deleteById(id);
    }
}
