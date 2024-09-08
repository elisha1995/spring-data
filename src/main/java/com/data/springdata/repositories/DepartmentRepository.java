package com.data.springdata.repositories;

import com.data.springdata.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByBuilding(String building);
    Department findByName(String name);
}
