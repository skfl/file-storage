package com.skfl.services.impl;

import com.skfl.ResponseInfo;
import com.skfl.entitites.StoredFile;
import com.skfl.repositories.PostgreFileRepository;
import com.skfl.repositories.StoredFileRepository;
import com.skfl.services.FileUploadService;
import com.skfl.utils.MultipartFileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

//    private final StoredFileRepository fileRepository; todo:send info via mb
    private final PostgreFileRepository postgreFileRepository;

    @Override
    public ResponseInfo upload(MultipartFile file) {
        UUID uuid = UUID.randomUUID();
        String fileName = MultipartFileUtils.getMultipartFileFilename(file);
        String fileExtension = MultipartFileUtils.getMultipartFileExtension(file);
        try {
            postgreFileRepository.storeFile(file.getInputStream(), uuid.toString());
//            fileRepository.save(StoredFile.builder()
//                    .name(fileName)
//                    .extension(fileExtension)
//                    .uuid(uuid.toString())
//                    .uploadedAt(Instant.now())
//                    .build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseInfo.builder()
                .message(uuid.toString())
                .build();
    }
}
