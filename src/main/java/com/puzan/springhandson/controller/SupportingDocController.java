package com.puzan.springhandson.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.puzan.springhandson.exception.PostResourceNotFoundException;
import com.puzan.springhandson.model.SupportingDoc;
import com.puzan.springhandson.repository.EnrollmentRepository;
import com.puzan.springhandson.repository.SupportingDocRepository;

@RestController
public class SupportingDocController {

    @Autowired
    private SupportingDocRepository supportingDocRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @GetMapping("/enrollments/{enrollmentId}/supportingdocs")
    public Page<SupportingDoc> SupportingDocsByEnrollmentId(@PathVariable (value = "enrollmentId") Long enrollmentId,
                                                Pageable pageable) {
        return supportingDocRepository.findByEnrollmentId(enrollmentId, pageable);
    }

    @PostMapping("/enrollments/{enrollmentId}/supportingdocs")
    public SupportingDoc createSupportingDoc(@PathVariable (value = "enrollmentId") Long enrollmentId,
                                 @Valid @RequestBody SupportingDoc supportingDoc) {
        return enrollmentRepository.findById(enrollmentId).map(enrollment -> {
            supportingDoc.setEnrollment(enrollment);
            return supportingDocRepository.save(supportingDoc);
        }).orElseThrow(() -> new PostResourceNotFoundException("EnrollmentId " + enrollmentId + " not found"));
    }

    @PutMapping("/enrollments/{enrollmentId}/supportingdocs/{supportingDocId}")
    public SupportingDoc updateSupportingDoc(@PathVariable (value = "enrollmentId") Long enrollmentId,
                                 @PathVariable (value = "supportingDocId") Long supportingDocId,
                                 @Valid @RequestBody SupportingDoc supportingDocRequest) {
        if(!enrollmentRepository.existsById(enrollmentId)) {
            throw new PostResourceNotFoundException("RnrollmentId " + enrollmentId + " not found");
        }

        return supportingDocRepository.findById(supportingDocId).map(supportingDoc -> {
            supportingDoc.setDocName(supportingDocRequest.getDocName());
            return supportingDocRepository.save(supportingDoc);
        }).orElseThrow(() -> new PostResourceNotFoundException("EnrollmentId " + enrollmentId + "not found"));
    }

    @DeleteMapping("/enrollments/{enrollmentId}/supportingdocs/{supportingDocId}")
    public ResponseEntity<?> deleteSupportingDoc(@PathVariable (value = "enrollmentId") Long enrollmentId,
                              @PathVariable (value = "supportingDocId") Long supportingDocId) {
        return supportingDocRepository.findByIdAndEnrollmentId(supportingDocId, enrollmentId).map(supportingDoc -> {
            supportingDocRepository.delete(supportingDoc);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new PostResourceNotFoundException("supportingDoc not found with id " + supportingDocId + " and EnrollmentId " + enrollmentId));
    }
}