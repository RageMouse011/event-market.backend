package kz.dar.tech.eventservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Properties;

@Configuration
public class KafkaTopicConfiguration {


    @Bean
    public NewTopic eventTopic() {
        return TopicBuilder.name("event-topic")
                .partitions(2)
                .replicas(1)
                .compact()
                .build();
    }
}
