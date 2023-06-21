package com.skfl.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FileCanNotBeUploadedException extends RuntimeException {

    public FileCanNotBeUploadedException(String message) {
        super(message);
    }
}
