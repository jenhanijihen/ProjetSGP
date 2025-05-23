package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.Machine;

import java.util.List;
import java.util.Optional;

public interface MachineService {
    List<Machine> findAll();
    Optional<Machine> findById(Long id);
    Machine save(Machine machine);
    void delete(Long id);
    List<Machine> findByEtat(String etat);

}
