package com.example.demo.aop;


import com.example.demo.Oggetto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class FifthAspect {
    //Lavora sul valore di ritorno di 'sestoMetodo()'

    @AfterReturning(value = "execution(* com.example.demo.service.TestService.sestoMetodo())",
            returning = "retValue")
    public void firstAdvice(Oggetto retValue) {
        System.out.println("sono in afterReturning.");
        retValue.setStringa("Pluto");
    }

    @Around(value = "execution(* com.example.demo.service.TestService.ottavoMetodo(..))")
    public Object secondAdvice(ProceedingJoinPoint jp) {
        Object retStr = null;
        try {
            retStr = jp.proceed();
        } catch (Throwable th) {
            //catturo l'eccezione lanciata da ottavoMetodo()
            //in modo da tornare nel metodo chiamante
            retStr = "Errore, eccezione gestita nell'advice";
            // se lancio una nuova eccezione il software si stoppa
            //throw new Exception()
        }

        //Restituisco al metodo chiamante "stringa"
        return retStr;
    }

    @Around(value = "execution(* com.example.demo.service.TestService.nonoMetodo(..))")
    public Object thirdAdvice(ProceedingJoinPoint jp) {
        Object retStr = null;
        retStr = null;
        try {
            retStr = jp.proceed();
        } catch (IllegalArgumentException e) {
            //Gestisco l'eccezione lanciata da nonoMetodo() e la rilancio
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        //Restituisco al metodo chiamante "stringa"
        return retStr;
    }

    // Viene invocato ogni qualvolta viene eseguito un metodo del bean riportato nel pointcut
    @Before("bean(oggetto)")
    public void ninthAdvice() {
        System.out.println("sono in ninthAdvice");
    }




}
