package com.jihenjenhani.projetsgp.service.impl;

import com.jihenjenhani.projetsgp.entity.Produit;
import com.jihenjenhani.projetsgp.repository.ProduitRepository;
import com.jihenjenhani.projetsgp.service.ProduitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository repository;

    public ProduitServiceImpl(ProduitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Produit> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Produit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Produit save(Produit produit) {
        return repository.save(produit);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
