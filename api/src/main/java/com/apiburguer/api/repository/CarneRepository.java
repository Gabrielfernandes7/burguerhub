package com.apiburguer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiburguer.api.model.Carne;

public interface CarneRepository extends JpaRepository<Carne, Long>{
    
}
