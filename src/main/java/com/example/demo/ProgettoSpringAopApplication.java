package com.example.demo;


import com.example.demo.service.TestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProgettoSpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgettoSpringAopApplication.class, args);
    }


    //    @Bean
//    public CommandLineRunner firstCommandLineRunner (String [] args){
//        return runner->{
//            System.out.println("hello world");
//        };
//    }

//	@Bean
//	public CommandLineRunner secondCommandLineRunner (TestService testService){
//		return runner->{
////            testService.primoMetodo();
////			System.out.println("valore di ritorno = "+testService.sestoMetodo().getStringa());
////			System.out.println("valore di ritorno = "+testService.ottavoMetodo(false));
//			System.out.println("valore di ritorno = "+testService.nonoMetodo(true));
//		};
//	}

    @Bean
	public CommandLineRunner secondCommandLineRunner (TestService testService, Oggetto oggetto){
	return runner->{
//            testService.primoMetodo();
//			System.out.println("valore di ritorno = "+testService.sestoMetodo().getStringa());
//			System.out.println("valore di ritorno = "+testService.ottavoMetodo(false));
//			System.out.println("valore di ritorno = "+testService.nonoMetodo(true));
//            System.out.println("hello");
//            oggetto.stampa();
        testService.secondoMetodo();
        };
	}




    @Bean("oggetto")
    public Oggetto metodo() {
        System.out.println("Sto creando oggetto");
        return new Oggetto();
    }


}
