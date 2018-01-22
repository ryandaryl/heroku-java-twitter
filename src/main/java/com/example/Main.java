package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;

import com.twittergraph.TwitterGrapherBot;

@Controller
@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @RequestMapping(value={ "/", "/{twitterHandle}" })
  String hello(Map<String, Object> model, @PathVariable Optional<String> twitterHandle) {
    String gexf = TwitterGrapherBot.getGraph(
        twitterHandle.isPresent() ? twitterHandle.get() : "springframework"
    );
    model.put("mytext", gexf);
    return "hello";
  }  

}