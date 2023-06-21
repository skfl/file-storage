package com.skfl.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
