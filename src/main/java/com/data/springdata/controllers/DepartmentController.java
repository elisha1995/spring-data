package com.data.springdata.controllers;

import com.data.springdata.models.Department;
import com.data.springdata.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/building/{building}")
    public List<Department> getDepartmentsByBuilding(@PathVariable String building) {
        return departmentService.findByBuilding(building);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        return departmentService.findByName(name);
    }

    @GetMapping("/getAll")
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/getDepartmentById/{code}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String code) {
        return departmentService.findById(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String code, @RequestBody Department departmentDetails) {
        return departmentService.findById(code)
                .map(department -> {
                    department.setName(departmentDetails.getName());
                    department.setBuilding(departmentDetails.getBuilding());
                    department.setDirector(departmentDetails.getDirector());
                    return ResponseEntity.ok(departmentService.save(department));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String code) {
        return departmentService.findById(code)
                .map(department -> {
                    departmentService.deleteById(code);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
