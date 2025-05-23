package com.jihenjenhani.projetsgp.controller;

import com.jihenjenhani.projetsgp.dto.MaintenanceDTO;
import com.jihenjenhani.projetsgp.entity.Maintenance;
import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.entity.Produit;
import com.jihenjenhani.projetsgp.entity.Technicien;
import com.jihenjenhani.projetsgp.mapper.ObjectMapperUtils;
import com.jihenjenhani.projetsgp.service.MachineService;
import com.jihenjenhani.projetsgp.service.MaintenanceService;
import com.jihenjenhani.projetsgp.service.TechnicienService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    private final MaintenanceService service;
    private final MachineService machineService;
    private final TechnicienService technicienService;

    public MaintenanceController(MaintenanceService service, MachineService machineService, TechnicienService technicienService) {
        this.service = service;
        this.machineService = machineService;
        this.technicienService = technicienService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceDTO>> getAll() {
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(service.findAll(), MaintenanceDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(m -> ResponseEntity.ok(ObjectMapperUtils.map(m, MaintenanceDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MaintenanceDTO dto) {
        Machine machine = dto.getMachine();
        Technicien technicien = dto.getTechnicien();

        if (machine == null || technicien == null) {
            return ResponseEntity.badRequest().body("Machine ou Technicien introuvable");
        }

        Maintenance entity = ObjectMapperUtils.map(dto, Maintenance.class);
        entity.setMachine(machine);
        entity.setTechnicien(technicien);


        // mise à jour de l'état de la machine
        machine.setEtat("EN_MAINTENANCE");
        machineService.save(machine);

        // mise à jour du technicien avec machine assignée
        technicien.setMachineAssignee(machine);
        technicienService.save(technicien); // AJOUTE CETTE LIGNE pour persister

        Maintenance saved = service.save(entity);
        return ResponseEntity.ok(ObjectMapperUtils.map(saved, MaintenanceDTO.class));
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MaintenanceDTO dto) {
        return service.findById(id)
                .map(existing -> {
                    Machine machine =dto.getMachine();
                    Technicien technicien = dto.getTechnicien();

                    if (machine == null || technicien == null) {
                        return ResponseEntity.badRequest().body("Machine ou Technicien introuvable");
                    }

                    Maintenance toUpdate = ObjectMapperUtils.map(dto, Maintenance.class);
                    toUpdate.setId(id);
                    toUpdate.setMachine(machine);
                    toUpdate.setTechnicien(technicien);

                    Maintenance updated = service.save(toUpdate);
                    return ResponseEntity.ok(ObjectMapperUtils.map(updated, MaintenanceDTO.class));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id).map(m -> {
            service.delete(id);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/{id}/terminer")
    public ResponseEntity<?> terminerMaintenance(@PathVariable Long id) {
        return service.findById(id).map(maintenance -> {
            Machine machine = maintenance.getMachine();
            Technicien technicien = maintenance.getTechnicien();

            if (machine != null) {
                machine.setEtat("EN_MARCHE");
                machineService.save(machine);
            }

            if (technicien != null) {
                technicien.setMachineAssignee(null); // Libère le technicien
                technicienService.save(technicien);
            }

//            service.save(maintenance); // persisté
//            service.delete(id); // supprime la maintenance après
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }



}
