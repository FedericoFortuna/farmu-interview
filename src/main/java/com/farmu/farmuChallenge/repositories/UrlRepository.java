package com.farmu.farmuChallenge.repositories;

import com.farmu.farmuChallenge.entities.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
}




