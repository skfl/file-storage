package com.skfl;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseInfo {
    private String message;
}
