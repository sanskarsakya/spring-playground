package com.puzan.springhandson.dto;

import java.util.List;
import java.util.Set;

public class EnrollmentSuppportingDocDto {
    private Long id;
    private List<SupportingDocDto> supportingDocDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SupportingDocDto> getSupportingDocDtos() {
        return supportingDocDtos;
    }

    public void setSupportingDocDtos(List<SupportingDocDto> supportingDocDtos) {
        this.supportingDocDtos = supportingDocDtos;
    }
}
