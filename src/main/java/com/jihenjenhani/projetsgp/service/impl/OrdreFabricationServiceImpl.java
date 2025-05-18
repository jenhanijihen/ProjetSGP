package com.jihenjenhani.projetsgp.service.impl;

import com.jihenjenhani.projetsgp.entity.OrdreFabrication;
import com.jihenjenhani.projetsgp.repository.OrdreFabricationRepository;
import com.jihenjenhani.projetsgp.service.OrdreFabricationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdreFabricationServiceImpl implements OrdreFabricationService {

    private final OrdreFabricationRepository repository;

    public OrdreFabricationServiceImpl(OrdreFabricationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrdreFabrication> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OrdreFabrication> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OrdreFabrication save(OrdreFabrication ordre) {
        return repository.save(ordre);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
