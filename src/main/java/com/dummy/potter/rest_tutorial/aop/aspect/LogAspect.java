package com.dummy.potter.rest_tutorial.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(com.dummy.potter.rest_tutorial.aop.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object retVal = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        logger.info("{} executed in {} ms", proceedingJoinPoint.getSignature(), executionTime);
        return retVal;
    }
}
