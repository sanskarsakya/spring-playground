package com.puzan.springhandson.controller;

import com.puzan.springhandson.services.DocSetting.DocSettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocSettingController {

    @Autowired
    private DocSettingService docSettingService;

    
    @PostMapping("/employers/supportingdocs")
    public SupportingDoc createSupportingDoc(@PathVariable (value = "enrollmentId") Long enrollmentId,
                                 @Valid @RequestBody SupportingDoc supportingDoc) {
        return enrollmentRepository.findById(enrollmentId).map(enrollment -> {
            supportingDoc.setEnrollment(enrollment);
            return supportingDocRepository.save(supportingDoc);
        }).orElseThrow(() -> new PostResourceNotFoundException("EnrollmentId " + enrollmentId + " not found"));
    }
    
}
