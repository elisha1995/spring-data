package com.data.springdata.services;

import com.data.springdata.models.Department;
import com.data.springdata.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    /*public Optional<Department> findById(String code) {
        return departmentRepository.findById(code);
    }*/

    // Caching the Department retrieval by code
    @Cacheable(value = "department", key = "#code")
    public Department getDepartment(String code) {
        System.out.println("Fetching department from database...");
        return departmentRepository.findById(code).orElse(null);
    }

    // Declarative Transaction for Saving a Department
    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    // Declarative Transaction with Propagation and Isolation Levels for Updates
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Department updateDepartment(String code, Department departmentDetails) {
        Optional<Department> departmentOptional = departmentRepository.findById(code);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setName(departmentDetails.getName());
            department.setBuilding(departmentDetails.getBuilding());
            department.setDirector(departmentDetails.getDirector());
            return departmentRepository.save(department);
        }
        return null;
    }

    // Programmatic Transaction Management for Deleting a Department
    public void deleteDepartment(String code) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            departmentRepository.deleteById(code);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    /*public void deleteById(String code) {
        departmentRepository.deleteById(code);
    }*/

    public List<Department> findByBuilding(String building) {
        return departmentRepository.findByBuilding(building);
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    // Cache Eviction on Department Deletion
    @CacheEvict(value = "departments", key = "#code")
    public void removeDepartmentFromCache(String code) {
        // This will evict the cache entry after the department is deleted
    }

    // Cache Eviction on Department Updates
    @CacheEvict(value = "departments", key = "#code")
    public Department evictCacheAndUpdate(String code, Department departmentDetails) {
        return updateDepartment(code, departmentDetails);
    }
}
