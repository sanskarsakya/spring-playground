package com.puzan.springhandson.services.enrollment;

import java.util.List;
import java.util.Set;

import com.puzan.springhandson.dto.EnrollmentSuppportingDocDto;
import com.puzan.springhandson.dto.SupportingDocDto;

public interface EnrollmentService {
    List<SupportingDocDto> saveSupportingDoc(EnrollmentSuppportingDocDto enrollmentSuppportingDocDto) throws Exception;
}
