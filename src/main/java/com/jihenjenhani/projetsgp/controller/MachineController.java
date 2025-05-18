package com.jihenjenhani.projetsgp.controller;

import com.jihenjenhani.projetsgp.dto.MachineDTO;
import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.mapper.ObjectMapperUtils;
import com.jihenjenhani.projetsgp.service.MachineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    private final MachineService service;

    public MachineController(MachineService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MachineDTO>> getAll() {
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(service.findAll(), MachineDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MachineDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(m -> ResponseEntity.ok(ObjectMapperUtils.map(m, MachineDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MachineDTO> create(@RequestBody MachineDTO dto) {
        Machine machine = ObjectMapperUtils.map(dto, Machine.class);
        Machine saved = service.save(machine);
        return ResponseEntity.ok(ObjectMapperUtils.map(saved, MachineDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MachineDTO> update(@PathVariable Long id, @RequestBody MachineDTO dto) {
        return service.findById(id)
                .map(existing -> {
                    Machine toUpdate = ObjectMapperUtils.map(dto, Machine.class);
                    toUpdate.setId(id);
                    Machine updated = service.save(toUpdate);
                    return ResponseEntity.ok(ObjectMapperUtils.map(updated, MachineDTO.class));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id).map(machine -> {
            service.delete(id);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
