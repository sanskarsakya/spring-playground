package com.puzan.springhandson.controller;

import java.util.List;

import javax.validation.Valid;

import com.puzan.springhandson.dto.EmployerDto;
import com.puzan.springhandson.services.Employer.EmployerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/enrollments/supportingdoc")
    public EmployerDto createEmployer(@Valid @RequestBody EmployerDto employerDto) {
        try {
            return employerService.save(employerDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
