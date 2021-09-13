package com.genekz.jpa.service;

import com.genekz.jpa.domain.enums.EmployeeExceptionCode;
import com.genekz.jpa.exception.EmployeeException;
import com.genekz.jpa.model.Employee;
import com.genekz.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeeRepository repository;

    public Employee saveOrUpdate(final Employee employee) {
        return repository.save(employee);
    }

    public Employee findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription()));
    }

    public void deleteById(final Long id) {
        try {
            repository.deleteById(id);
        } catch(Exception ex) {
            throw new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE002.getDescription());
        }
    }
}
