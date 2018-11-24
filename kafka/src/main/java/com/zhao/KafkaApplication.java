package com.zhao;

import com.zhao.kafka.KafKaConsumer;
import com.zhao.kafka.KafKaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

    @Autowired
    KafKaProducer kafKaProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        kafKaProducer.send();
    }
}
