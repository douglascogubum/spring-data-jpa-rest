package com.genekz.jpa.service;

import com.genekz.jpa.domain.enums.EmployeeExceptionCode;
import com.genekz.jpa.exception.EmployeeException;
import com.genekz.jpa.model.Employee;
import com.genekz.jpa.repository.EmployeeRepository;
import com.genekz.jpa.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeReportDynamicService {

    private final EmployeeRepository repository;

    public List<Employee> getEmployeeReport(final String name, final String cpf, final BigDecimal salary, final LocalDate hiringDate) {
        List<Employee> employees = repository.findAll(Specification.where(EmployeeSpecification.name(name)
                .or(EmployeeSpecification.cpf(cpf))
                .or(EmployeeSpecification.salary(salary))
                .or(EmployeeSpecification.hiringDate(hiringDate))));

        if(employees.isEmpty()) {
            throw  new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription());
        }
        return employees;
    }
}
