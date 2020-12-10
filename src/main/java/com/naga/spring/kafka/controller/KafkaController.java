package com.naga.spring.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/naga/k")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Value("${kafka.msg.topic}")
    private String MSG_TOPIC ;

    @GetMapping("/")
    public String SayHello(){return  "Welcome to kafka example";}

    @GetMapping("/{msg}")
    public String publishMessage(@PathVariable ("msg") String msg){


        kafkaTemplate.send(MSG_TOPIC,msg);
        return  "Welcome to kafka example";
    }
}
