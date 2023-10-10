package com.deliveryboy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    // The `topic()` method is defining a new topic using `TopicBuilder` from the Kafka library
    @Bean
    public NewTopic topic() {

        // the code is setting the name of the topic to `AppConstants.LOCATION_TOPIC_NAME`
        return TopicBuilder
                .name(AppConstants.LOCATION_TOPIC_NAME)
//                 you can also specify the number of partitions and replicas using the commented lines `.partitions()` and `.replicas()`
//                .partitions()
//                .replicas()
                .build();


    }

}
