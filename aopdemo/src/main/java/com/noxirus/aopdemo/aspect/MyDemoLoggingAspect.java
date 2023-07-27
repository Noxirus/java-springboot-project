package com.noxirus.aopdemo.aspect;

import com.noxirus.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(pointcut = "execution(* com.noxirus.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        System.out.println("Method Advising on: " + theJoinPoint.getSignature().toShortString());

        System.out.println("Results: " + result);
    }


    @Before("com.noxirus.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("Executing command");

        MethodSignature methodSignature = (MethodSignature)theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                Account theAccount = (Account)tempArg;
                System.out.println(theAccount.getName());
                System.out.println(theAccount.getLevel());
            }
        }
    }
}
