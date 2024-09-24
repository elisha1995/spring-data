package com.data.springdata.services;

import com.data.springdata.model.*;
import com.data.springdata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    // Employee CRUD operations
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
