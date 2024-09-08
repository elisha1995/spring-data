package com.data.springdata.services;

import com.data.springdata.models.Department;
import com.data.springdata.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(String code) {
        return departmentRepository.findById(code);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteById(String code) {
        departmentRepository.deleteById(code);
    }

    public List<Department> findByBuilding(String building) {
        return departmentRepository.findByBuilding(building);
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}
