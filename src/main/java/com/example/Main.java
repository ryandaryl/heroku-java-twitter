package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

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
  @CrossOrigin(origins = "*")
  public @ResponseBody String hello(@PathVariable Optional<String> twitterHandle) {
    String gexf = TwitterGrapherBot.getGraph(
        twitterHandle.isPresent() ? twitterHandle.get() : "springframework"
    );
    return gexf;
  }  

}