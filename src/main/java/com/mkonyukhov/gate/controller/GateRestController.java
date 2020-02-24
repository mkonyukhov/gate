package com.mkonyukhov.gate.controller;

import com.mkonyukhov.gate.configuration.kafka.KafkaProperties;
import com.mkonyukhov.gate.model.Message;
import com.mkonyukhov.gate.service.SendingService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@EnableConfigurationProperties(KafkaProperties.class)
public class GateRestController {
    private final SendingService sendingService;
    private final KafkaProperties kafkaProperties;
    private final Validator validator;

    public GateRestController(SendingService sendingService, KafkaProperties kafkaProperties, Validator validator) {
        this.sendingService = sendingService;
        this.kafkaProperties = kafkaProperties;
        this.validator = validator;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putMessage(@PathVariable("id") String entityId, @RequestBody Message payload) {
        if (validator.isUuid(entityId)) {
            if (sendingService.send(entityId, payload, kafkaProperties.getOutTopicName())) {
                return ResponseEntity.ok(entityId);
            } else {
                return ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .build();
            }
        }

        return ResponseEntity
                .notFound()
                .build();
    }
}
