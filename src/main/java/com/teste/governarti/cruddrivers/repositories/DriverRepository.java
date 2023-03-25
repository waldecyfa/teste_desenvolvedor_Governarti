package com.teste.governarti.cruddrivers.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.governarti.cruddrivers.model.entities.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
