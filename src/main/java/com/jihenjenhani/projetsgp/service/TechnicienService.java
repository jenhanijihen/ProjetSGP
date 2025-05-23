package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.Technicien;

import java.util.List;
import java.util.Optional;

public interface TechnicienService {
    List<Technicien> findAll();
    Optional<Technicien> findById(Long id);
    Technicien save(Technicien technicien);
    void delete(Long id);

}
