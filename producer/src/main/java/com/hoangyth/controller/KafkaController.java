package com.hoangyth.controller;

import com.hoangyth.service.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final Producer producer;

    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping(value = "/publish")
    public String sendMessageToKafkaTopic() {
        for (int i = 0; i < 10; i++) {
            this.producer.sendMessage(String.valueOf(i));
        }
        return "success";
    }
}
