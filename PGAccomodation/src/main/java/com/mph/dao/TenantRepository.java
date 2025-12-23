package com.mph.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mph.model.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
}