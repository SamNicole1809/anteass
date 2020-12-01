package com.sam.anteass.organization.config;

import com.sam.anteass.common.exception.*;
import com.sam.anteass.common.utils.AnteassReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Component
@RestControllerAdvice
public class ExceptionConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e) {
        if (e instanceof AnteassNotFoundException) {
            return AnteassReturn.notFound();
        }
        if (e instanceof AnteassParamException) {
            return AnteassReturn.paramError();
        }
        if (e instanceof AnteassSqlException) {
            return AnteassReturn.serverError();
        }
        if (e instanceof AnteassNotAllowedException) {
            return AnteassReturn.notAllowed();
        }
        if (e instanceof AnteassForbiddenException) {
            return AnteassReturn.forbidden();
        }
        logger.error(e.getMessage());
        return AnteassReturn.serverError();
    }
}
