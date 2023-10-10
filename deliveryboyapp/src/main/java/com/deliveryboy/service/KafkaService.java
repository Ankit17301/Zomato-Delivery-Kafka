package com.deliveryboy.service;

import com.deliveryboy.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    //  This template is an implementation of the `ProducerFactory` interface, which allows you to send messages to Kafka topics using the specified key and value types.
    //  It provides a convenient way to produce messages to Kafka without dealing with the low-level details of creating a producer
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    // `kafkaTemplate.send()` method, you can send the `location` to the `AppConstants.LOCATION_TOPIC_NAME` topic in Kafka.
    // This will publish the updated location, allowing consumers to process it.
    // It's a simple and effective way to update and share location information in real-time
    public boolean updateLocation(String location) {
        try {
            this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
            return true;
        } catch (Exception e) {
            logger.error("Error while sending location to Kafka", e);
            return false;
        }
    }




}
