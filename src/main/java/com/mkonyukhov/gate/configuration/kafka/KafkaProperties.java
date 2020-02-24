package com.mkonyukhov.gate.configuration.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {
    private String bootstrapServers;
    private String outTopicName;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getOutTopicName() {
        return outTopicName;
    }

    public void setOutTopicName(String outTopicName) {
        this.outTopicName = outTopicName;
    }
}
