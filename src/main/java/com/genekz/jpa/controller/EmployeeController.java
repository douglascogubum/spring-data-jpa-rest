package com.genekz.jpa.controller;

import com.genekz.jpa.model.Employee;
import com.genekz.jpa.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeesService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveOrUpdate(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveOrUpdate(employee));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Employee>> findAll(@RequestParam final Integer page) {
        return ResponseEntity.ok(employeeService.findAll(page));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final Long id) {
        employeeService.deleteById(id);
    }
}
