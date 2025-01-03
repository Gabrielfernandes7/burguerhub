package com.apiburguer.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.apiburguer.api.model.dto.CarneRequestDTO;
import com.apiburguer.api.model.dto.CarneResponseDTO;
import com.apiburguer.api.service.CarneService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
@RequestMapping("/carnes")
public class CarneController {
    private final CarneService carneService;

    public CarneController(CarneService carneService) {
        this.carneService = carneService;
    }

    @PostMapping
    public ResponseEntity<Void> criarCarneController(
        @RequestBody CarneRequestDTO carne
    ) {
        carneService.criarCarne(carne);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CarneResponseDTO>> listarCarnesController() {
        return ResponseEntity.ok(carneService.listarCarnes());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarneResponseDTO> atualizarParcialCarneController(
        @PathVariable Long id, @RequestBody CarneRequestDTO data
    ) {
        CarneResponseDTO updatedTodo = carneService.atualizarParcialcarne(id, data);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<CarneResponseDTO>> apagarCarneController(
        @PathVariable Long id
    ) {
        return ResponseEntity.ok(carneService.apagarCarne(id));
    }
    
}
