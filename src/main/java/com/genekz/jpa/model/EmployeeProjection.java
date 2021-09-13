package com.genekz.jpa.model;

import java.math.BigDecimal;

public interface EmployeeProjection {
    Long getId();
    String getName();
    BigDecimal getSalary();
}
