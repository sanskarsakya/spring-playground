package com.puzan.springhandson.dto;

import java.util.List;

public class EmployerDocSettingDto {
    private Long Id;
    private List<DocSettingDto> docSettingDtoList;
    
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public List<DocSettingDto> getDocSettingDtoList() {
        return docSettingDtoList;
    }
    public void setDocSettingDtoList(List<DocSettingDto> docSettingDtoList) {
        this.docSettingDtoList = docSettingDtoList;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
