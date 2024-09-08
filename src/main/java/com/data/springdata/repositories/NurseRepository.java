package com.data.springdata.repositories;

import com.data.springdata.models.Nurse;
import com.data.springdata.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer> {
    List<Nurse> findByRotation(String rotation);
    List<Nurse> findBySalaryGreaterThan(double salary);
    Nurse findByWard(Ward ward);
}
