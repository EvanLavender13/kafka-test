package com.lavender;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProducerApp {

    private static final String TOPIC_NAME = "my-topic";

    @Bean
    public NewTopic topic()
    {
        return TopicBuilder.name(TOPIC_NAME)
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) 
    {
        return (args) -> template.send(TOPIC_NAME, "test");
    }    
    
    public static void main(String[] args)
    {
        SpringApplication.run(ProducerApp.class, args);
    }
}
