package com.skfl.services;

import com.skfl.ResponseInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    ResponseInfo upload(MultipartFile file);
}
