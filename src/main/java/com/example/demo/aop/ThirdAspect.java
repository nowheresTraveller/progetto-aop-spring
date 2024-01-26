package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(1)
public class ThirdAspect {
    @Before(value="com.example.demo.aop.SecondAspect.finalAdvice()")
    public void firstAdvice(){
        System.out.println("Sono in firstAdvice() di ThirdAspect e il suo pointcut è quello contenuto in finalAdvice() di SecondAspect");
    }
}
