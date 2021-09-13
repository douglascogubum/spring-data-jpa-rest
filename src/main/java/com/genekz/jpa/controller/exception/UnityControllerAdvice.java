package com.genekz.jpa.controller.exception;

import com.genekz.jpa.domain.ExceptionMessage;
import com.genekz.jpa.exception.UnityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestControllerAdvice
public class UnityControllerAdvice {

    @ExceptionHandler(value = {UnityException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessage resourceNotFoundException(UnityException exception) {
        return ExceptionMessage.builder()
            .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS).toString())
            .message(exception.getMessage())
            .build();
    }
}
