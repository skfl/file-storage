package com.skfl.services.impl;

import com.skfl.repositories.PostgreFileRepository;
import com.skfl.services.FileDownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class FileDownloadServiceImpl implements FileDownloadService {

    private final PostgreFileRepository postgreFileRepository;

    @Override
    public InputStream download(String uuid) {
        return postgreFileRepository.getFile(uuid);
    }
}
