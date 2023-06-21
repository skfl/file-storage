package com.skfl.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileInfo {

    String name;
    int size;
    String extension;
    Instant uploadedAt;
}
