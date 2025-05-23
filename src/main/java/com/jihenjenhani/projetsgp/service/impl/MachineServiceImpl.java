package com.jihenjenhani.projetsgp.service.impl;

import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.repository.MachineRepository;
import com.jihenjenhani.projetsgp.service.MachineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService {

    private final MachineRepository repository;

    public MachineServiceImpl(MachineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Machine> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Machine> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Machine save(Machine machine) {
        return repository.save(machine);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    @Override
    public List<Machine> findByEtat(String etat) {
        return repository.findByEtat(etat);
    }


}
