package com.mkonyukhov.gate.controller;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validator {
    private final Pattern pattern =
            Pattern.compile("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}");

    public boolean isUuid(String entityId) {
        return pattern.matcher(entityId).find();
    }
}
