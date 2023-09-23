package com.farmu.shorterurl.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "images")
@Getter
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private String extension;

    @Column(name = "original_path")
    private String originalPath;

    @Column(name = "shorter_path")
    private String shorterPath;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}