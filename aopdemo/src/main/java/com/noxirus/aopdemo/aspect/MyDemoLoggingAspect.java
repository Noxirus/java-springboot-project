package com.noxirus.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(* add*(com.noxirus.aopdemo.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>>>> Executing @Before advice on addAccount()");
    }

}
