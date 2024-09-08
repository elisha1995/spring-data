package com.data.springdata.services;

import com.data.springdata.models.Nurse;
import com.data.springdata.models.Ward;
import com.data.springdata.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardService {
    @Autowired
    private WardRepository wardRepository;

    public List<Ward> findAll() {
        return wardRepository.findAll();
    }

    public Optional<Ward> findById(Integer id) {
        return wardRepository.findById(id);
    }

    public List<Ward> findByDepartmentCode(String departmentCode) {
        return wardRepository.findByDepartmentCode(departmentCode);
    }

    public Ward findBySupervisor(Nurse supervisor) {
        return wardRepository.findBySupervisor(supervisor);
    }

    public List<Ward> findByNumberOfBedsGreaterThan(int beds) {
        return wardRepository.findByNumberOfBedsGreaterThan(beds);
    }

    public Ward save(Ward ward) {
        return wardRepository.save(ward);
    }

    public void deleteById(Integer id) {
        wardRepository.deleteById(id);
    }
}
