package com.naga.spring.kafka.config;


import com.naga.spring.kafka.model.Item;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ItemKafkaConfiguration {

    @Bean
    public ProducerFactory <String, Item> producerFactory() {
        Map<String, Object> itemConfig = new HashMap<>();

        itemConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        itemConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        itemConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<String, Item>(itemConfig);
    }

    @Bean
    public KafkaTemplate<String, Item> getKafkaTemplate()
    {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaTemplate<String, String> getTemplate()
    {
        return new KafkaTemplate<String, String>();
    }
}
