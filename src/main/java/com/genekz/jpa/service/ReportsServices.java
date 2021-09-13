package com.genekz.jpa.service;

import com.genekz.jpa.domain.enums.EmployeeExceptionCode;
import com.genekz.jpa.exception.EmployeeException;
import com.genekz.jpa.model.Employee;
import com.genekz.jpa.model.EmployeeProjection;
import com.genekz.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportsServices {

    private final EmployeeRepository repository;

    private List<Employee> consult = new ArrayList<>(10);
    private List<EmployeeProjection> projection = new ArrayList<>(10);

    public List<Employee> getEmployees(final String name) {
        consult = repository.findByName(name);

        if(consult.isEmpty()) {
            throw new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription());
        }
        return consult;
    }

    public List<Employee> getEmployeesWithSalaryAndHiringDate(final String name, final BigDecimal salary, final LocalDate hiringDate) {
        consult = repository.findNameSalaryGreaterHiringDate(name, salary, hiringDate);

        if(consult.isEmpty()) {
            throw new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription());
        }
        return consult;
    }

    public List<Employee> getEmployeesWithHiringDate(final LocalDate hiringDate){
        consult = repository.findHiringDate(hiringDate);

        if(consult.isEmpty()) {
            throw new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription());
        }
        return consult;
    }

    public List<EmployeeProjection> getEmployeesProjection(){
        projection = repository.findEmployeeSalary();

        if(projection.isEmpty()) {
            throw new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription());
        }
        return projection;
    }

}
