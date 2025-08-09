package com.wipro.akshay;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.wipro.akshay.controllers.QuestionController.getAllQuestions(..))")
    public void logBeforeAddQuestion(JoinPoint joinPoint) {
        log.error("===== Executing Before Advice for getAllQuestions() =====");
        log.error("Calling method: {}", joinPoint.getSignature().getName());
        log.error("Target class: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.error("Method arguments: {}", joinPoint.getArgs()); 
        log.error("=========================================================");
    }
}
