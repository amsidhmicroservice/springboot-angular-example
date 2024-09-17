package com.amsidh.mvc.controller;

import com.amsidh.mvc.controller.model.response.HelloWorldBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
@CrossOrigin(origins = "*")
public class HelloWorldController {

    @GetMapping(value = "hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
      log.info("Inside getHelloWorldBean method");
        return HelloWorldBean.builder().message("Hello World from Springboot").build();
    }

    @GetMapping(value = "hello-world-bean/{username}")
    public HelloWorldBean getHelloWorldBeanWithUserName(@PathVariable(name = "username") String username){
        log.info("Inside getHelloWorldBeanWithUserName method");
        return HelloWorldBean.builder().message(String.format("Hello %s! from World of Springboot", username)).build();
    }
}
