package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.Technicien;
import com.jihenjenhani.projetsgp.repository.TechnicienRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicienService {

    private final TechnicienRepository repository;

    public TechnicienService(TechnicienRepository repository) {
        this.repository = repository;
    }

    public List<Technicien> findAll() {
        return repository.findAll();
    }

    public Optional<Technicien> findById(Long id) {
        return repository.findById(id);
    }

    public Technicien save(Technicien technicien) {
        return repository.save(technicien);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
