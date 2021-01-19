package com.puzan.springhandson.services.enrollment;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.puzan.springhandson.dto.EnrollmentSuppportingDocDto;
import com.puzan.springhandson.dto.SupportingDocDto;
import com.puzan.springhandson.model.Enrollment;
import com.puzan.springhandson.model.SupportingDoc;
import com.puzan.springhandson.repository.EnrollmentRepository;
import com.puzan.springhandson.repository.SupportingDocRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private SupportingDocRepository supportingDocRepository;

    @Override
    public List<SupportingDocDto> saveSupportingDoc(EnrollmentSuppportingDocDto enrollmentSuppportingDocDto)
            throws Exception {
        // TODO Auto-generated method stub

        // get enrollment by id
        // convert supporting doc dto to entity
        // assign fetched enrollment and prepare as set
        // persist supporting doc list
        // convert supporting doc from entity to dto
        // prepare as set
        // return the prepared dto list

        Optional<Enrollment> enrollmentFound = enrollmentRepository.findById(enrollmentSuppportingDocDto.getId());
        Enrollment enrollmentFoundGet = enrollmentFound.get();

        List<SupportingDoc> supportingDocs = enrollmentSuppportingDocDto.getSupportingDocDtos().stream()
                .map(supportingDocDto -> {
                    SupportingDoc supportingDoc = new SupportingDoc();
                    supportingDoc.setDocName(supportingDocDto.getDocName());
                    supportingDoc.setEnrollment(enrollmentFoundGet);
                    return supportingDoc;
                }).collect(Collectors.toList());

        List<SupportingDoc> CreatedSupportingDocs = supportingDocRepository.saveAll(supportingDocs);

        List<SupportingDocDto> supportingDocsDto = CreatedSupportingDocs.stream()
                .map(supportingDoc -> {
                    SupportingDocDto supportingDocDto = new SupportingDocDto();
                    supportingDocDto.setId(supportingDoc.getId());
                    supportingDocDto.setDocName(supportingDoc.getDocName());
                    return supportingDocDto;
                }).collect(Collectors.toList());

        return supportingDocsDto;
    }

}
