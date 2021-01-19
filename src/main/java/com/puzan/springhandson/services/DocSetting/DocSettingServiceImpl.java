package com.puzan.springhandson.services.DocSetting;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.puzan.springhandson.dto.DocSettingDto;
import com.puzan.springhandson.dto.EmployerDocSettingDto;
import com.puzan.springhandson.model.DocSetting;
import com.puzan.springhandson.model.Employer;
import com.puzan.springhandson.repository.DocSettingRepository;
import com.puzan.springhandson.repository.EmployerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class DocSettingServiceImpl implements DocSettingService {

    @Autowired
    private DocSettingRepository docSettingRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public List<DocSettingDto> saveDocumentSettingForEmployer(EmployerDocSettingDto employerDocSettingDto)
            throws Exception {

        Optional<Employer> employerFound = employerRepository.findById(employerDocSettingDto.getId());
        Employer enrollmentFoundGet = employerFound.get();

        List<DocSetting> docSettingsToCreate = employerDocSettingDto.getDocSettingDtoList().stream()
                .map(docSettingDto -> {

                    DocSetting docSetting = new DocSetting();
                    docSetting.setLabel(docSettingDto.getLabel());
                    docSetting.setDocNos(docSettingDto.getDocNos());
                    docSetting.setEmployer(enrollmentFoundGet);

                    return docSetting;
                }).collect(Collectors.toList());

        List<DocSetting> docSettingsCreated = docSettingRepository.saveAll(docSettingsToCreate);

        List<DocSettingDto> docSettingsCreatedDtos = docSettingsCreated.stream().map(docSetting -> {
            
            DocSettingDto docSettingDto = new DocSettingDto();
            docSettingDto.setId(docSetting.getId());
            docSettingDto.setLabel(docSetting.getLabel());
            docSettingDto.setDocNos(docSetting.getDocNos());

            return docSettingDto;
        }).collect(Collectors.toList());

        return docSettingsCreatedDtos;
    }

}
