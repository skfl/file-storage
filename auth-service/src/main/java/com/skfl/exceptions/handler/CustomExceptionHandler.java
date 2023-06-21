package com.skfl.exceptions.handler;

import com.skfl.ApplicationErrorResponse;
import com.skfl.exceptions.AccountNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
@Log4j2
public class CustomExceptionHandler {

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ApplicationErrorResponse handleAccountNotFoundException(AccountNotFoundException e) {
        String error = "Account not Found";
        log.warn(e.getMessage());
        return ApplicationErrorResponse.
                builder()
                .statusCode(HttpStatus.I_AM_A_TEAPOT.value())
                .error(error)
                .message(e.getMessage())
                .timestamp(Instant.now())
                .build();
    }
}
