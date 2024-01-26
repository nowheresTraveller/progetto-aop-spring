package com.example.demo.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecondAspect {

    @Pointcut("execution(* com.example.demo.service.TestService.*Metodo())")
    public void powerMethod(){}

    @Pointcut("execution(* com.example.demo.service.TestService.quartoMetodo())")
    public void fstOtherMethod(){
        System.out.println("sono nell'advice 'fstOtherMethod()");
    }
    @Pointcut("execution(* com.example.demo.service.TestService.primoMetodo())")
    public void scdOtherMethod(){
        System.out.println("sono nell'advice 'scdOtherMethod()");
    }

    @Pointcut("powerMethod() && !(fstOtherMethod() || scdOtherMethod())")
    public void finalAdvice(){}

}
