package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.Produit;
import com.jihenjenhani.projetsgp.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository repository;

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> findAll() {
        return repository.findAll();
    }

    public Optional<Produit> findById(Long id) {
        return repository.findById(id);
    }

    public Produit save(Produit produit) {
        return repository.save(produit);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}