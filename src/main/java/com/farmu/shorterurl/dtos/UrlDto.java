package com.farmu.shorterurl.dtos;

import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UrlDto {
    private String shorterPath;
}
