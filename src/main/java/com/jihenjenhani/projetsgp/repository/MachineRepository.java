package com.jihenjenhani.projetsgp.repository;

import com.jihenjenhani.projetsgp.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    List<Machine> findByEtat(String etat);

}

