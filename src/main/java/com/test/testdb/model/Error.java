package com.test.testdb.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Error {
    private String message;
    private String status;

    public Error(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
