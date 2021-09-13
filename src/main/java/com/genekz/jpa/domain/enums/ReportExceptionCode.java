package com.genekz.jpa.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ReportExceptionCode {

    REPORT_EXCEPTION_CODE001("REPORT_EXCEPTION_CODE001", "Employee not found with this name");

    private String type;
    private String description;
}
