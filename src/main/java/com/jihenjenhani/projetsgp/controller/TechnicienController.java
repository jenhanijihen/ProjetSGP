package com.jihenjenhani.projetsgp.controller;


import com.jihenjenhani.projetsgp.entity.Technicien;
import com.jihenjenhani.projetsgp.service.TechnicienService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/techniciens")
@CrossOrigin("*")
public class TechnicienController {

    private final TechnicienService service;

    public TechnicienController(TechnicienService service) {
        this.service = service;
    }

    @GetMapping
    public List<Technicien> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technicien> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Technicien create(@RequestBody Technicien technicien) {
        return service.save(technicien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technicien> update(@PathVariable Long id, @RequestBody Technicien technicien) {
        return service.findById(id)
                .map(existing -> {
                    technicien.setId(id);
                    return ResponseEntity.ok(service.save(technicien));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
