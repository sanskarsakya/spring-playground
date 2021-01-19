package com.puzan.springhandson.services.Employer;

import com.puzan.springhandson.dto.EmployerDto;
import com.puzan.springhandson.model.Employer;
import com.puzan.springhandson.repository.EmployerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public EmployerDto save(EmployerDto employerDto) throws Exception {
        var employerToCreate = new Employer();
        employerToCreate.setName(employerDto.getName());

        var employerCreated = employerRepository.save(employerToCreate);

        var employerCreatedDto = new EmployerDto();
        employerCreatedDto.setId(employerCreated.getId());
        employerCreatedDto.setName(employerCreated.getName());

        return employerCreatedDto;
    }
    
}
