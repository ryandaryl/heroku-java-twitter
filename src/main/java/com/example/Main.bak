package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@SpringBootApplication
public class Main {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }
  
  @RequestMapping("/")
  String hello(Map<String, Object> model) {
    model.put("mytext", "Hello from Java!");
    return "hello";
  }  

}