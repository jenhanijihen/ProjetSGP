package com.jihenjenhani.projetsgp.service;


import com.jihenjenhani.projetsgp.entity.Maintenance;
import com.jihenjenhani.projetsgp.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {
    private final MaintenanceRepository repository;

    public MaintenanceService(MaintenanceRepository repository) {
        this.repository = repository;
    }

    public List<Maintenance> findAll() {
        return repository.findAll();
    }

    public Optional<Maintenance> findById(Long id) {
        return repository.findById(id);
    }

    public Maintenance save(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
