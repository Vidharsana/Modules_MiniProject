package com.mph.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mph.model.PG;

public interface PGRepository extends JpaRepository<PG, Long> {

    // Assumes PG has: private City city; and City has: private Long cityId;
    List<PG> findByCityCityId(Long cityId);

    List<PG> findByLocality(String locality);
}
