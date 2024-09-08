package com.data.springdata.controllers;

import com.data.springdata.models.Doctor;
import com.data.springdata.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/getAll")
    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getDoctorsBySpeciality(@PathVariable String speciality) {
        return doctorService.findBySpeciality(speciality);
    }

    @GetMapping("/employee-number/{employeeNumber}")
    public Doctor getDoctorByEmployeeNumber(@PathVariable int employeeNumber) {
        return doctorService.findByEmployeeNumber(employeeNumber);
    }

    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }


}
