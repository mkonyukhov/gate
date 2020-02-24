package com.mkonyukhov.gate.service;

import com.mkonyukhov.gate.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class SendingService {
    private static final Logger logger = LoggerFactory.getLogger(SendingService.class);

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public SendingService(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean send(String entityId, Message payload, String topic) {
        ListenableFuture<SendResult<String, Message>> resultFuture = kafkaTemplate
                .send(topic, entityId, payload);

        resultFuture.addCallback(
                result -> logger.debug(
                        "Sent message with key {} in {}",
                        entityId,
                        topic
                ),
                ex -> logger.debug(
                        "Unable to send message with key {} in {} due {}",
                        entityId,
                        topic,
                        ex.getMessage()
                )
        );

        try {
            resultFuture.get();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
