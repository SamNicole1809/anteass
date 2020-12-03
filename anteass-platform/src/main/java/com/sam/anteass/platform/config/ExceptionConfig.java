package com.sam.anteass.platform.config;

import com.sam.anteass.common.exception.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e) {
        return AnteassExceptionHandler.exceptionHandler(e);
    }

}
