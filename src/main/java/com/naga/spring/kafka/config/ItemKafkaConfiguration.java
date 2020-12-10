package com.naga.spring.kafka.config;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.naga.spring.kafka.model.Item;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ItemKafkaConfiguration {

    @Bean
    private ProducerFactory <String, Item> producerFactory() {
        Map<String, Object> itemConfig = new HashMap<>();

        itemConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        itemConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        itemConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializable.class);

        return new DefaultKafkaProducerFactory<String, Item>(itemConfig);
    }

    @Bean
    public KafkaTemplate<String, Item> getKafkaTemplate()
    {
        return new KafkaTemplate<>(producerFactory());
    }
}
