package com.example.SpringCorePractice.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.SpringCorePractice.service.*.*(..))")
    public void beforeServiceMethods() {
        System.out.println("[AOP] Method in UserService is about to execute...");
    }

    @After("execution(* com.example.SpringCorePractice.service.*.*(..))")
    public void afterServiceMethods() {
        System.out.println("[AOP] Method in UserService has finished executing.");
    }
}
