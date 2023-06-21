package com.skfl.exceptions.handler;

import com.skfl.ApplicationErrorResponse;
import com.skfl.exceptions.FileCanNotBeUploadedException;
import com.skfl.exceptions.FileNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(FileCanNotBeUploadedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApplicationErrorResponse handleFileCanNotBeUploadedException(FileCanNotBeUploadedException e) {
        String error = "File Can Not Be Uploaded";
        log.warn(e.getMessage());
        e.printStackTrace();
        return ApplicationErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .error(error)
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApplicationErrorResponse handleFileNotFoundException(FileNotFoundException e) {
        String error = "File Not Found";
        log.warn(e.getMessage());
        e.printStackTrace();
        return ApplicationErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .error(error)
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}

