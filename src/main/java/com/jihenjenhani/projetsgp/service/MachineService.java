package com.jihenjenhani.projetsgp.service;

import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    private final MachineRepository repository;

    public MachineService(MachineRepository repository) {
        this.repository = repository;
    }

    public List<Machine> findAll() {
        return repository.findAll();
    }

    public Optional<Machine> findById(Long id) {
        return repository.findById(id);
    }

    public Machine save(Machine machine) {
        return repository.save(machine);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}