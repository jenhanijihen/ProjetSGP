package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.OrdreFabrication;
import com.jihenjenhani.projetsgp.repository.OrdreFabricationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdreFabricationService {
    private final OrdreFabricationRepository repository;

    public OrdreFabricationService(OrdreFabricationRepository repository) {
        this.repository = repository;
    }

    public List<OrdreFabrication> findAll() {
        return repository.findAll();
    }

    public Optional<OrdreFabrication> findById(Long id) {
        return repository.findById(id);
    }

    public OrdreFabrication save(OrdreFabrication ordre) {
        return repository.save(ordre);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
