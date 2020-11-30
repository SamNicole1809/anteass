package com.sam.anteass.organization.config;

import com.sam.anteass.common.annotation.AnteassPermission;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AopConfig {

    @Pointcut("@annotation(com.sam.anteass.common.annotation.AnteassPermission)")
    private void permission(){}

    @Around("permission() && @annotation(anteassPermission)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, AnteassPermission anteassPermission) throws Throwable {
        String[] permissions = anteassPermission.value();
        if (Arrays.binarySearch(permissions, "edu:test") < 0) {
            return "403";
        }
        System.out.println(Arrays.asList(permissions));
        return proceedingJoinPoint.proceed();
    }

}
