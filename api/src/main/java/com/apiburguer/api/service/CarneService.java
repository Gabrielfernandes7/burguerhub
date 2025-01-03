package com.apiburguer.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apiburguer.api.model.Carne;
import com.apiburguer.api.model.dto.CarneRequestDTO;
import com.apiburguer.api.model.dto.CarneResponseDTO;
import com.apiburguer.api.repository.CarneRepository;

@Service
public class CarneService {
    private CarneRepository carneRepository;

    private CarneService(CarneRepository carneRepository) {
        this.carneRepository = carneRepository;
    }

    public void criarCarne(CarneRequestDTO data) {
        Carne tipoCarneData = new Carne(data);
        carneRepository.save(tipoCarneData);
        return;
    }

    public List<CarneResponseDTO> listarCarnes() {
        return carneRepository
            .findAll()
            .stream()
            .map(CarneResponseDTO::new)
            .toList();
    }

    public CarneResponseDTO atualizarParcialcarne(Long id, CarneRequestDTO data) {
        Optional<Carne> carneOptional = carneRepository.findById(id);

        if (carneOptional.isPresent()) {
            Carne carne = carneOptional.get();

            if (data.tipoCarne() != null) {
                carne.setTipoCarne(data.tipoCarne());
            }

            carneRepository.save(carne);

            return new CarneResponseDTO(carne);
        } else {
            throw new RuntimeException("Opção de carne não encontrada");
        }
    }

    public List<CarneResponseDTO> apagarCarne(Long id) {
        carneRepository.deleteById(id);
        
        return listarCarnes();
    }

}
