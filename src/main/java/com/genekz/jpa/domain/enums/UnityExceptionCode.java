package com.genekz.jpa.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UnityExceptionCode {

    UNITY_EXCEPTION_CODE001("ROLE_EXCEPTION_CODE001", "Unity not found"),
    UNITY_EXCEPTION_CODE002("ROLE_EXCEPTION_CODE001", "Not possible to delete Unity. Not found");

    private String type;
    private String description;
}
