package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Oggetto {
  private String stringa;

  public void stampa(){
    System.out.println("stampa");
  }
}
