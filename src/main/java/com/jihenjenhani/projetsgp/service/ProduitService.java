package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    List<Produit> findAll();
    Optional<Produit> findById(Long id);
    Produit save(Produit produit);
    void delete(Long id);
}
