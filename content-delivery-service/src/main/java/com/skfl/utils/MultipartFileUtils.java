package com.skfl.utils;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileUtils {

    private MultipartFileUtils() {
    }

    public static String getMultipartFileExtension(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            return "";
        }
        int extensionIndex = originalFilename.lastIndexOf('.');
        if (extensionIndex == -1 || extensionIndex > originalFilename.length() - 1) {
            return "";
        }
        return originalFilename.substring(extensionIndex+1);
    }

    public static String getMultipartFileFilename(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            return "";
        }
        int extensionIndex = originalFilename.lastIndexOf('.');
        if (extensionIndex == -1 || extensionIndex > originalFilename.length() - 1) {
            return "";
        }
        return originalFilename.substring(originalFilename.lastIndexOf(' ')+1, extensionIndex);
    }
}
