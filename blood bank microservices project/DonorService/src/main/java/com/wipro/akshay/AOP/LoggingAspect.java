package com.wipro.akshay.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.wipro.akshay.services.DonorServiceImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Started: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.wipro.akshay.services.DonorServiceImpl.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Finished: " + joinPoint.getSignature().getName());
    }
}