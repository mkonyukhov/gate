package com.mkonyukhov.gate.model.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageSerializer implements Serializer {
    private static final Logger logger = LoggerFactory.getLogger(MessageSerializer.class);

    @Override
    public byte[] serialize(String topic, Object payload) {
        byte[] retVal = null;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            retVal = objectMapper.writeValueAsBytes(payload);
        } catch (Exception e) {
            logger.error("Serializer error: {}", e.getMessage());
        }

        return retVal;
    }
}
