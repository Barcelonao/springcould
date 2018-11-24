package com.zhao.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafKaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send() {
        kafkaTemplate.send("java-test-one", System.currentTimeMillis() + "");
    }

}
