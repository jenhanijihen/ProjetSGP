package com.jihenjenhani.projetsgp.controller;

import com.jihenjenhani.projetsgp.dto.ProduitDTO;
import com.jihenjenhani.projetsgp.entity.Produit;
import com.jihenjenhani.projetsgp.mapper.ObjectMapperUtils;
import com.jihenjenhani.projetsgp.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProduitDTO>> getAll() {
        List<ProduitDTO> produits = ObjectMapperUtils.mapAll(service.findAll(), ProduitDTO.class);
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(produit -> ResponseEntity.ok(ObjectMapperUtils.map(produit, ProduitDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProduitDTO> create(@RequestBody ProduitDTO dto) {
        Produit produit = ObjectMapperUtils.map(dto, Produit.class);
        Produit saved = service.save(produit);
        return ResponseEntity.ok(ObjectMapperUtils.map(saved, ProduitDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitDTO> update(@PathVariable Long id, @RequestBody ProduitDTO dto) {
        return service.findById(id)
                .map(existing -> {
                    Produit toUpdate = ObjectMapperUtils.map(dto, Produit.class);
                    toUpdate.setId(id);
                    Produit updated = service.save(toUpdate);
                    return ResponseEntity.ok(ObjectMapperUtils.map(updated, ProduitDTO.class));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(produit -> {
                    service.delete(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
