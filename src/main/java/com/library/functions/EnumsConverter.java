package com.library.functions;

import com.library.enums.Status;

import java.util.Arrays;

public class EnumsConverter {
    public static Status convertStringToStatus(String status) {
        return Arrays.stream(Status.values())
                .filter(status1 -> status1.getType().equalsIgnoreCase(status))
                .findFirst()
                .orElse(Status.AVAILABLE);
    }
}
