package com.data.springdata.services;

import com.data.springdata.models.Employee;
import com.data.springdata.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findBySurname(String surname) {
        return employeeRepository.findBySurname(surname);
    }

    public List<Employee> findByAddressContaining(String addressKeyword) {
        return employeeRepository.findByAddressContaining(addressKeyword);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
