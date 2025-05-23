package com.jihenjenhani.projetsgp.service.impl;

import com.jihenjenhani.projetsgp.entity.Maintenance;
import com.jihenjenhani.projetsgp.repository.MaintenanceRepository;
import com.jihenjenhani.projetsgp.service.MaintenanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository repository;

    public MaintenanceServiceImpl(MaintenanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Maintenance> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Maintenance> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
