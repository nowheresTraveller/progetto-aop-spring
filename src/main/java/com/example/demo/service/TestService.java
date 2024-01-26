package com.example.demo.service;

import com.example.demo.Oggetto;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public void primoMetodo() {
        System.out.println("xxx");
    }

    public void secondoMetodo() {
        System.out.println("secondo metodo");
    }

    public void terzoMetodo() {
        System.out.println("terzoMetodo");
    }

    public void quartoMetodo() {
        System.out.println("sono nel quarto metodo.");
    }

    public void quintoMetodo() {
        System.out.println("sono il quinto metodo.");
    }

    public Oggetto sestoMetodo() {
        Oggetto oggetto = new Oggetto();
        oggetto.setStringa("Pippo");
        return oggetto;
    }

    public Integer settimoMetodo() {
        return 4;
    }

    public  String ottavoMetodo(boolean bool){
        if (bool) {
            throw  new IllegalArgumentException();
        }
        return "ok";
    }

    public  String nonoMetodo(boolean bool){
        if (bool) {
            throw  new IllegalArgumentException();
        }
        return "ok";
    }

}
