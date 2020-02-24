package com.mkonyukhov.gate.controller;

import com.mkonyukhov.gate.configuration.kafka.KafkaProperties;
import com.mkonyukhov.gate.model.Message;
import com.mkonyukhov.gate.service.SendingService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@EnableConfigurationProperties(KafkaProperties.class)
public class GateRestController {
    private final SendingService sendingService;
    private final KafkaProperties kafkaProperties;

    public GateRestController(SendingService sendingService, KafkaProperties kafkaProperties) {
        this.sendingService = sendingService;
        this.kafkaProperties = kafkaProperties;
    }

    @PutMapping("/{id}")
    public void putMessage(@PathVariable("id") String entityId, @RequestBody Message payload) {
        sendingService.send(entityId, payload, kafkaProperties.getOutTopicName());
    }
}
