package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.OrdreFabrication;

import java.util.List;
import java.util.Optional;

public interface OrdreFabricationService {
    List<OrdreFabrication> findAll();
    Optional<OrdreFabrication> findById(Long id);
    OrdreFabrication save(OrdreFabrication ordre);
    void delete(Long id);
}
