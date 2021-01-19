package com.puzan.springhandson.repository;

import com.puzan.springhandson.model.Employer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    
}
