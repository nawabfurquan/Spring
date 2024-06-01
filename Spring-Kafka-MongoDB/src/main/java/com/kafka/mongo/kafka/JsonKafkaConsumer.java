package com.kafka.mongo.kafka;

import com.kafka.mongo.entity.User;
import com.kafka.mongo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "user_json", groupId = "userGroup")
    public void consume(User user) {
        logger.info(String.format("Message received: %s", user.toString()));
        userRepository.save(user);
    }
}
