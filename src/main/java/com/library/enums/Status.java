package com.library.enums;

import lombok.Getter;

@Getter
public enum Status {
    AVAILABLE("Available"),
    NOT_AVAILABLE("Not available"),
    REQUESTED("Requested");

    private final String type;

    Status(String type) {
        this.type = type;
    }
}
