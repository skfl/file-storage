package com.skfl.utils;

import com.skfl.dto.FileInfo;

import java.io.File;

public class FileDataParser {

    private FileDataParser() {

    }

    public static FileInfo parseFileInfoFromFile(File file) {
        return FileInfo.builder()
                .name(file.getName())
                .extension("1")
                .build();
    }
}
