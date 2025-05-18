package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.Maintenance;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {
    List<Maintenance> findAll();
    Optional<Maintenance> findById(Long id);
    Maintenance save(Maintenance maintenance);
    void delete(Long id);
}
