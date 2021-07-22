package com.qtech.orderoengine.model.request;

public final class MenuRequest {

    private final String color;

    private final Integer number;

    public MenuRequest(String color, Integer number) {
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public Integer getNumber() {
        return number;
    }
}
