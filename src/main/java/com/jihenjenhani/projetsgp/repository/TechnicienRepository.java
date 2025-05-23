package com.jihenjenhani.projetsgp.repository;

import com.jihenjenhani.projetsgp.entity.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
//    List<Technicien> findByMachineAssigneeIsNull();

}
