package com.skfl.services;

import java.io.InputStream;

public interface FileDownloadService {
    InputStream download(String uuid);
}
