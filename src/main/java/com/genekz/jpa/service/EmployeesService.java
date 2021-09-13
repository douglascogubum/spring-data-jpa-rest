package com.genekz.jpa.service;

import com.genekz.jpa.domain.enums.EmployeeExceptionCode;
import com.genekz.jpa.exception.EmployeeException;
import com.genekz.jpa.model.Employee;
import com.genekz.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeeRepository repository;

    private List<Employee> employees = new ArrayList<>(10);

    public Employee saveOrUpdate(final Employee employee) {
        return repository.save(employee);
    }

    public Employee findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription()));
    }

    public List<Employee> findAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "name"));
        Page<Employee> employee = repository.findAll(pageable);
        employee.forEach(emp -> employees.add(emp));
        if(employees.isEmpty()) {
            throw  new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE001.getDescription());
        }
        return employees;
    }

    public void deleteById(final Long id) {
        try {
            repository.deleteById(id);
        } catch(Exception ex) {
            throw new EmployeeException(EmployeeExceptionCode.EMPLOYEES_EXCEPTION_CODE002.getDescription());
        }
    }
}
