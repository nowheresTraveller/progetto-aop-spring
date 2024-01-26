package com.example.demo.aop;


import com.example.demo.exception.ApplicationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Esempio di Aspect
 */
@Component
@Aspect
public class FirstAspect {
    private Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //Declaration pointcut: gli advice firstBefSamplAdv() e secondBefSamplAdv() hanno lo stesso pointcut dichiarato in questo advice.
    @Pointcut(value = "execution (public void quartoMetodo())")
    public void sampleAdvice() {
    }

    //Primo advice eseguito prima di  "execution (public void quartoMetodo())"
    @Before("sampleAdvice()")
    public void firstBefSamplAdv() {
        System.out.println("firstBefSamplAdv");
    }


    //secondo advice eseguito prima di "execution (public void quartoMetodo())"
    @Before("sampleAdvice()")
    public void secondBefSamplAdv() {
        System.out.println("secondBefSamplAdv");
    }

    //Esegue l'advice around all'esecuzione del metodo 'primoMetodo()' contenuto nella classe TestService
    @Before(("execution (* com.example.demo.service.TestService.primoMetodo())"))
    public void firstAdvice() {
        System.out.println("firstAdvice");
    }

    //Esegue l'advice prima dell'esecuzione di secondoMetodo(). Il metodo può appartenere a qualsiasi classe del progetto
    @Before(value = "execution (public void secondoMetodo())")
    public void secondAdvice() {
        System.out.println("ciao");
    }

    //Esegue l'advice prima dell'esecuzione di un metodo dell'app che comincia con "add". Il metodo può appartenere a qualsiasi classe del progetto
    @Before(value = "execution (public void add*())")
    public void fifthAdvice() {
        System.out.println("hello");
    }


    //Esegue l'advice dopo l'esecuzione di un metodo public, senza specificare il tipo di ritorno, di nome 'addMoney()' contenuto nel progetto
    @After(value = "execution (public * addMoney())")
    public void sixthAdvice() {
        System.out.println("hello");
    }







//    Esegue l'advice prima dell'esecuzione di *Metodo(). Questo ha 0 o più parametri:
//            @Before("execution(com.example.demo.service.TestService.ottavoMetodo(..)))"
//    Esegue l'advice prima dell'esecuzione di get*(). Questo deve avere un solo parametro e può essere di qualsiasi tipo:
//            @Before("execution(com.example.demo.service.TestService.get*(*)))"
//    Esegue l'advice prima dell'esecuzione di un qualsiasi metodo con nessun parametro contenuto in qualsiasi classe del package 'service':
//            @Before("execution(com.example.demo.service.*.*()))"

//    Pointcut combinations:
//      &&, ||, !

//    Pointcut designator:
//            execution
//            bean -> permette di eseguire l'advice nel caso viene eseguito il metodo di un bean.
//                   es: @Before("bean(oggetto)"
//            within -> permette di eseguire l'advice nel caso viene eseguito un metodo di una classe contenuta in un package:
//                   es: @Before("within(com.sofinn.service)"
//            args -> permette di eseguire l'advice nel caso venga eseguito un qualsiasi metodo dell'app. che abbia determinati parametri:
//                   es:@Before("args(String)")
//            this->?
//            target->?


//    TIPI POINTCUT:

//    //Esegue l'advice around all'esecuzione del metodo 'primoMetodo()' contenuto nella classe TestService
//    @Before(("execution (* com.example.demo.service.TestService.primoMetodo())"))
//    public void firstAdvice() {
//        System.out.println("firstAdvice");
//    }
//
//    //Esegue l'advice prima dell'esecuzione di secondoMetodo(). Il metodo può appartenere a qualsiasi classe del progetto
//    @Before(value = "execution (public void secondoMetodo())")
//    public void secondAdvice() {
//        System.out.println("ciao");
//    }
//
//    //Esegue l'advice prima dell'esecuzione di un metodo dell'app che comincia con "add". Il metodo può appartenere a qualsiasi classe del progetto
//    @Before(value = "execution (public void add*())")
//    public void fifthAdvice() {
//        System.out.println("hello");
//    }
//
//
//    //Esegue l'advice dopo l'esecuzione di un metodo public, senza specificare il tipo di ritorno, di nome 'addMoney()' contenuto nel progetto
//    @After(value = "execution (public * addMoney())")
//    public void sixthAdvice() {
//        System.out.println("hello");
//    }

//    @Before(("execution (public void com.example.demo.service.TestService.*)"))
//    public void firstAdvice() {
//        System.out.println("firstAdvice");
//    }

//    @Before(("execution (* com.example.demo.service.TestService.*)"))
//    public void firstAdvice() {
//        System.out.println("firstAdvice");
//    }
//    @Before(("execution (* com.example.demo.service.*.*)"))
//    public void firstAdvice() {
//        System.out.println("firstAdvice");
//    }
//



}
