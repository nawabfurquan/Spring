package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    // Logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // Pointcut declarations
    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // Advices
    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> @Before on: " + method);

        Object[] args = joinPoint.getArgs();
        for (Object arg:
             args) {
            logger.info("===> Argument: " + arg);
        }

    }


    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    private void afterReturning(
            JoinPoint joinPoint, Object result
    ) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> @AfterReturning on: " + method);

        logger.info("===> Result: " + result);
    }


}
