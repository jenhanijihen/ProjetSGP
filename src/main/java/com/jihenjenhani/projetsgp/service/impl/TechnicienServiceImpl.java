package com.jihenjenhani.projetsgp.service.impl;

import com.jihenjenhani.projetsgp.entity.Technicien;
import com.jihenjenhani.projetsgp.repository.TechnicienRepository;
import com.jihenjenhani.projetsgp.service.TechnicienService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicienServiceImpl implements TechnicienService {

    private final TechnicienRepository repository;

    public TechnicienServiceImpl(TechnicienRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Technicien> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Technicien> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Technicien save(Technicien technicien) {
        return repository.save(technicien);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
