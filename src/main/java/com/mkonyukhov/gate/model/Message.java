package com.mkonyukhov.gate.model;

public class Message {
    private String name;
    private int sum;
    private int multiplier;

    public Message(String name, int sum, int multiplier) {
        this.name = name;
        this.sum = sum;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
