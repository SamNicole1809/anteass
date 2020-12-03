package com.sam.anteass.common.exception;

import com.sam.anteass.common.utils.AnteassReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnteassExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AnteassExceptionHandler.class);

    public static String exceptionHandler(Exception e) {
        if (e instanceof AnteassNotFoundException) {
            if (e.getMessage() != null) {
                return AnteassReturn.error(e.getMessage());
            }
            return AnteassReturn.notFound();
        }
        if (e instanceof AnteassCommonException) {
            return AnteassReturn.error(e.getMessage());
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
        if (e instanceof AnteassDataExistedException) {
            return AnteassReturn.error(e.getMessage());
        }
        logger.error(e.getMessage());
        return AnteassReturn.serverError();
    }

}
