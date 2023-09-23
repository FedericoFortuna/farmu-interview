package com.farmu.farmuChallenge.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
@Getter
@Builder
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_path")
    private String originalPath;

    @Column(name = "shorter_path")
    private String shorterPath;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;

}
