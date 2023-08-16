package com.noxirus.aopdemo.aspect;

import com.noxirus.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.noxirus.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("Executing around method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try{
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception exc){
            System.out.println(exc.getMessage());

            result = "Major accident, but relief is on the way";
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("Time taken: " + duration / 1000.0);

        return result;
    }

    @After("execution(* com.noxirus.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("Executing after method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.noxirus.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc)
    {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("Executing: " + method);

        System.out.println("Exception: " + theExc);
    }

    @AfterReturning(pointcut = "execution(* com.noxirus.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        System.out.println("Method Advising on: " + theJoinPoint.getSignature().toShortString());

        System.out.println("Results: " + result);

        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account tempAccount : result){
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
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
