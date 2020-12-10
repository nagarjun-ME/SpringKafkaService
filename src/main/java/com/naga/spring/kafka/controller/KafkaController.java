package com.naga.spring.kafka.controller;

import com.naga.spring.kafka.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Item> itemKafkaTemplate;

    @Value("${kafka.msg.topic}")
    private String MSG_TOPIC;

    @GetMapping("/")
    public String SayHello() {
        return "Welcome to kafka example";
    }

    /*
    @GetMapping("/{msg}")
    public String publishMessage(@PathVariable ("msg") String msg){

        logger.info("Publishing topic {}", msg);
        kafkaTemplate.send(MSG_TOPIC,msg);
        logger.info("{} has been published.", msg);
        return  "<h2> Heyy!! Message published successfully.</h2>";
    }
     */

    @GetMapping("/item/{itemName}")
    public String publishItem(@PathVariable("itemName") String itemName) {

        logger.info("Publishing item {}", itemName);
        itemKafkaTemplate.send(MSG_TOPIC, new Item("TA001", itemName, 2, 23.33));
        logger.info("Item : {} has been published.", itemName);
        return "<h2> Heyy!! Item : " + itemName + " published successfully.</h2>";
    }
}
