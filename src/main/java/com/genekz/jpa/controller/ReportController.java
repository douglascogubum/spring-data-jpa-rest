package com.genekz.jpa.controller;

import com.genekz.jpa.model.Employee;
import com.genekz.jpa.service.ReportsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("report")
public class ReportController {

    private final ReportsServices reportsServices;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> getEmployees(@PathVariable final String name) {
        return ResponseEntity.ok(reportsServices.getEmployees(name));
    }
}
