package com.genekz.jpa.service;

import com.genekz.jpa.domain.enums.EmployeeExceptionCode;
import com.genekz.jpa.exception.EmployeeException;
import com.genekz.jpa.model.Employee;
import com.genekz.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportsServices {

    private final EmployeeRepository repository;

    public List<Employee> getEmployees(final String name) {
        return repository.findByName(name).orElseThrow(() -> new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription()));
    }

}
