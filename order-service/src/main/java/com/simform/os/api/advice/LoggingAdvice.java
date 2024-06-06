package com.simform.os.api.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Centralized logging using Aspect Oriented Programming(AOP)
@Aspect
@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.simform.os.api.*.*.*(..) )")
    public void myPointcut(){

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getClass().getName();
        Object[] inputArray = proceedingJoinPoint.getArgs();

        log.info("Method invoked: " + className + " : " + methodName + " : " + "arguments: " +
                mapper.writeValueAsString(inputArray));

        Object response = proceedingJoinPoint.proceed();

        log.info("Method invoked: " + className + " : " + methodName + " : " + "response: " +
                mapper.writeValueAsString(response));

        return response;
    }

}
