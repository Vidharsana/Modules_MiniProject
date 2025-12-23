package com.mph.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mph.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
