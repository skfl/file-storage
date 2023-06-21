//package com.skfl.mappers;
//
//import com.skfl.dto.FileInfo;
//import com.skfl.entitites.StoredFile;
//
//public class StoredFileMapper {
//
//    private StoredFileMapper() {
//    }
//
//    public static FileInfo mapStoreFileToFileInfo(StoredFile storedFile) {
//        return FileInfo.builder()
//                .name(storedFile.getName())
//                .extension(storedFile.getExtension())
//                .size(storedFile.getSize())
//                .uploadedAt(storedFile.getUploadedAt())
//                .build();
//    }
//}
