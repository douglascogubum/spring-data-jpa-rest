package com.genekz.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleExceptionCode {

    ROLE_EXCEPTION_CODE001("ROLE_EXCEPTION_CODE001", "Role not found"),
    ROLE_EXCEPTION_CODE002("ROLE_EXCEPTION_CODE001", "Not possible to delete Role");

    private String type;
    private String description;
}
