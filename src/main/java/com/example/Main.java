package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import com.twittergraph.TwitterGrapherBot;

@Controller
@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
  
  @RequestMapping("/")
  String hello(Map<String, Object> model) {
    String gexf = TwitterGrapherBot.getGraph();
    model.put("mytext", gexf);
    return "hello";
  }  

}