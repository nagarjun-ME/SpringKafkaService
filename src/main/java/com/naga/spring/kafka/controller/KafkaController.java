package com.naga.spring.kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/naga/k")
public class KafkaController {

    @GetMapping("/")
    public String SayHello(){return  "Welcome to kafka example";}
}
