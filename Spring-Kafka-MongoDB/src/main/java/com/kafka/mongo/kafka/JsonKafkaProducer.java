package com.kafka.mongo.kafka;

import com.kafka.mongo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        logger.info(String.format("Message sent: %s", user.toString()));
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "user_json")
                .build();
        kafkaTemplate.send(message);
    }
}
