package com.genekz.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ExceptionMessage {

    private String timestamp;
    private String message;
}
