package com.farmu.farmuChallenge.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "URLS")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntity {

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "original_path")
    private String originalPath;

    @Column(name = "shorter_path")
    private String shorterPath;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;

}
