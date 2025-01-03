package com.apiburguer.api.model;

import com.apiburguer.api.model.dto.CarneRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "carnes")
@Entity
public class Carne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipoCarne;

    /* Contrutores */
    public Carne() {

    }

    public Carne(Long id, String tipoCarne) {
        this.id = id;
        this.tipoCarne = tipoCarne;
    }

    public Carne(CarneRequestDTO carneDataDto) {
        this.tipoCarne = carneDataDto.tipoCarne();
    }

    /* Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoCarne() {
        return tipoCarne;
    }

    public void setTipoCarne(String tipoCarne) {
        this.tipoCarne = tipoCarne;
    }
}
