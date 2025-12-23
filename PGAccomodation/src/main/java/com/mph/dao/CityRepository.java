package com.mph.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mph.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
