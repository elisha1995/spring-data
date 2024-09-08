package com.data.springdata.repositories;

import com.data.springdata.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findBySurname(String surname);
    List<Employee> findByAddressContaining(String addressKeyword);
}
