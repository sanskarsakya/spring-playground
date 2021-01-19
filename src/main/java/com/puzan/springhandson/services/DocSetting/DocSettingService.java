package com.puzan.springhandson.services.DocSetting;

import java.util.List;

import com.puzan.springhandson.dto.DocSettingDto;
import com.puzan.springhandson.dto.EmployerDocSettingDto;

public interface DocSettingService {
    List<DocSettingDto> saveDocumentSettingForEmployer(EmployerDocSettingDto employerDocSettingDto) throws Exception;
}
