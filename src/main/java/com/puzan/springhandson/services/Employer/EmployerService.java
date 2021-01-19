package com.puzan.springhandson.services.Employer;

import com.puzan.springhandson.dto.EmployerDto;
import com.puzan.springhandson.model.Employer;

public interface EmployerService {
    EmployerDto save(EmployerDto employer) throws Exception;
}
