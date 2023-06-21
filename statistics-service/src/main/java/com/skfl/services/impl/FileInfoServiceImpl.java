package com.skfl.services.impl;

import com.skfl.entities.StoredFile;
import com.skfl.exceptions.FileNotFoundException;
import com.skfl.repository.StoredFileRepository;
import com.skfl.services.FileInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FileInfoServiceImpl implements FileInfoService {

    private final StoredFileRepository fileRepository;

    @Override
    public String getFilenameByUUID(String uuid) {
        StoredFile found = fileRepository.findByUuid(uuid).orElseThrow(() -> {
            throw new FileNotFoundException("There is no file with such UUID");
        });
        return found.getName() + "." + found.getExtension();
    }
}
