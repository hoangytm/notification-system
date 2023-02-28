package com.hoangyth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic() {
        for (int i = 0; i < 10; i++) {
            this.producer.sendMessage(String.valueOf(i));
        }
    }
}
