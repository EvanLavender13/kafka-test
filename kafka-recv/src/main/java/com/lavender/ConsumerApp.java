package com.lavender;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class ConsumerApp {

    private static final String TOPIC_NAME = "my-topic";

    @Bean
    public NewTopic topic()
    {
        return TopicBuilder.name(TOPIC_NAME)
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(id = "ID", topics = TOPIC_NAME)
    public void listen(String message)
    {
        System.out.println(" [x] Received '" + message + "'");
    }
    

    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApp.class, args);
    }
}
