package com.apiburguer.api.model.dto;

import com.apiburguer.api.model.Carne;

public record CarneResponseDTO(Long id, String tipoCarne) {
    public CarneResponseDTO(Carne carne) {
        this(
            carne.getId(),
            carne.getTipoCarne()
        );
    }
}
