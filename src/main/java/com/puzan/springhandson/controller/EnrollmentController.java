package com.puzan.springhandson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import com.puzan.springhandson.dto.EnrollmentSuppportingDocDto;
import com.puzan.springhandson.dto.SupportingDocDto;
import com.puzan.springhandson.exception.PostResourceNotFoundException;
import com.puzan.springhandson.model.Enrollment;
import com.puzan.springhandson.repository.EnrollmentRepository;
import com.puzan.springhandson.services.enrollment.EnrollmentService;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public Page<Enrollment> getAllPosts(Pageable pageable) {
        return enrollmentRepository.findAll(pageable);
    }

    @PostMapping("/enrollments")
    public Enrollment createPost(@Valid @RequestBody Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @PostMapping("/enrollments/supportingdoc")
    public List<SupportingDocDto> createPost(@Valid @RequestBody EnrollmentSuppportingDocDto enrollment) {
        try {
            return enrollmentService.saveSupportingDoc(enrollment);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/enrollments/{enrollmentId}")
    public Enrollment updatePost(@PathVariable Long enrollmentId, @Valid @RequestBody Enrollment enrollmentRequest) {
        return enrollmentRepository.findById(enrollmentId).map(enrollment -> {
            enrollment.setName(enrollmentRequest.getName());
            return enrollmentRepository.save(enrollment);
        }).orElseThrow(() -> new PostResourceNotFoundException("PostId " + enrollmentId + " not found"));
    }


    @DeleteMapping("/enrollments/{enrollmentId}")
    public ResponseEntity<?> deletePost(@PathVariable Long enrollmentId) {
        return enrollmentRepository.findById(enrollmentId).map(enrollment -> {
            enrollmentRepository.delete(enrollment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new PostResourceNotFoundException("PostId " + enrollmentId + " not found"));
    }

}