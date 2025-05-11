package com.jihenjenhani.projetsgp.controller;

import com.jihenjenhani.projetsgp.entity.OrdreFabrication;
import com.jihenjenhani.projetsgp.service.OrdreFabricationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordres")
@CrossOrigin("*")
public class OrdreFabricationController {
    private final OrdreFabricationService service;

    public OrdreFabricationController(OrdreFabricationService service) {
        this.service = service;
    }



    @GetMapping
    public List<OrdreFabrication> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdreFabrication> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrdreFabrication create(@RequestBody OrdreFabrication ordre) {
        return service.save(ordre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdreFabrication> update(@PathVariable Long id, @RequestBody OrdreFabrication ordre) {
        return service.findById(id)
                .map(existing -> {
                    ordre.setId(id);
                    return ResponseEntity.ok(service.save(ordre));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
