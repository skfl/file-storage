package com.skfl.controllers;

import com.skfl.ResponseInfo;
import com.skfl.services.FileDownloadService;
import com.skfl.services.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {

    private final FileUploadService fileUploadService;
    private final FileDownloadService fileDownloadService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseInfo> uploadFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(fileUploadService.upload(file));
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("uuid") String uuid) {

        InputStreamResource resource = new InputStreamResource(fileDownloadService.download(uuid));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentDispositionFormData("attachment", fileInfoService.getFilenameByUUID(uuid));

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
