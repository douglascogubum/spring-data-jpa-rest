package com.genekz.jpa.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeExceptionCode {

    EMPLOYEES_EXCEPTION_CODE001("EMPLOYEES_EXCEPTION_CODE001", "Employee not found"),
    EMPLOYEES_EXCEPTION_CODE002("EMPLOYEES_EXCEPTION_CODE001", "Not possible to delete Employee. Not found");

    private String type;
    private String description;
}
