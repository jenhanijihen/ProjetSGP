package com.jihenjenhani.projetsgp.controller;

import com.jihenjenhani.projetsgp.dto.TechnicienDTO;
import com.jihenjenhani.projetsgp.entity.Technicien;
import com.jihenjenhani.projetsgp.mapper.ObjectMapperUtils;
import com.jihenjenhani.projetsgp.service.TechnicienService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/techniciens")
public class TechnicienController {

    private final TechnicienService service;

    public TechnicienController(TechnicienService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TechnicienDTO>> getAll() {
        List<TechnicienDTO> techniciens = ObjectMapperUtils.mapAll(service.findAll(), TechnicienDTO.class);
        return ResponseEntity.ok(techniciens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicienDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(t -> ResponseEntity.ok(ObjectMapperUtils.map(t, TechnicienDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TechnicienDTO> create(@RequestBody TechnicienDTO dto) {
        Technicien technicien = ObjectMapperUtils.map(dto, Technicien.class);
        Technicien saved = service.save(technicien);
        return ResponseEntity.ok(ObjectMapperUtils.map(saved, TechnicienDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicienDTO> update(@PathVariable Long id, @RequestBody TechnicienDTO dto) {
        return service.findById(id)
                .map(existing -> {
                    Technicien toUpdate = ObjectMapperUtils.map(dto, Technicien.class);
                    toUpdate.setId(id);
                    Technicien updated = service.save(toUpdate);
                    return ResponseEntity.ok(ObjectMapperUtils.map(updated, TechnicienDTO.class));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id).map(technicien -> {
            service.delete(id);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
