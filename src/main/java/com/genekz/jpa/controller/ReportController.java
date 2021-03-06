package com.genekz.jpa.controller;

import com.genekz.jpa.model.Employee;
import com.genekz.jpa.model.EmployeeProjection;
import com.genekz.jpa.service.EmployeeReportDynamicService;
import com.genekz.jpa.service.ReportsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportsServices reportsServices;
    private final EmployeeReportDynamicService dynamicService;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> getEmployees(@PathVariable final String name) {
        return ResponseEntity.ok(reportsServices.getEmployees(name));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam final String name, final BigDecimal salary, final LocalDate hiringDate) {
        return ResponseEntity.ok(reportsServices.getEmployeesWithSalaryAndHiringDate(name, salary, hiringDate));
    }

    @GetMapping("/hiring-date")
    public ResponseEntity<List<Employee>> getEmployeesWithHiringDate(@RequestParam final LocalDate hiringDate) {
        return ResponseEntity.ok(reportsServices.getEmployeesWithHiringDate(hiringDate));
    }

    @GetMapping("/projection")
    public ResponseEntity<List<EmployeeProjection>> getEmployeesWithHiringDate() {
        return ResponseEntity.ok(reportsServices.getEmployeesProjection());
    }

    @GetMapping("/specification")
    public ResponseEntity<List<Employee>> getSpecification(@RequestParam final String name, final String cpf, final BigDecimal salary, final LocalDate hiringDate) {
        return ResponseEntity.ok(dynamicService.getEmployeeReport(name, cpf, salary, hiringDate));
    }
}
