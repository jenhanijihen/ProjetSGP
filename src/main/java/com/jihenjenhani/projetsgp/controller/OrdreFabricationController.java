package com.jihenjenhani.projetsgp.controller;

import com.jihenjenhani.projetsgp.dto.OrdreFabricationDTO;
import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.entity.OrdreFabrication;
import com.jihenjenhani.projetsgp.entity.Produit;
import com.jihenjenhani.projetsgp.mapper.ObjectMapperUtils;
import com.jihenjenhani.projetsgp.service.MachineService;
import com.jihenjenhani.projetsgp.service.OrdreFabricationService;
import com.jihenjenhani.projetsgp.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordres")
public class OrdreFabricationController {

    private final OrdreFabricationService service;
    private final ProduitService produitService;
    private final MachineService machineService;

    public OrdreFabricationController(OrdreFabricationService service,
                                      ProduitService produitService,
                                      MachineService machineService) {
        this.service = service;
        this.produitService = produitService;
        this.machineService = machineService;
    }

    @GetMapping
    public ResponseEntity<List<OrdreFabricationDTO>> getAll() {
        return ResponseEntity.ok(ObjectMapperUtils.mapAll(service.findAll(), OrdreFabricationDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdreFabricationDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(o -> ResponseEntity.ok(ObjectMapperUtils.map(o, OrdreFabricationDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrdreFabricationDTO dto) {
        Produit produit = dto.getProduit();
        Machine machine = dto.getMachine();

        if (produit == null || machine == null) {
            return ResponseEntity.badRequest().body("Produit ou Machine introuvable");
        }

        OrdreFabrication entity = ObjectMapperUtils.map(dto, OrdreFabrication.class);
        entity.setProduit(produit);
        entity.setMachine(machine);

        OrdreFabrication saved = service.save(entity);
        return ResponseEntity.ok(ObjectMapperUtils.map(saved, OrdreFabricationDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OrdreFabricationDTO dto) {
        return service.findById(id)
                .map(existing -> {
                    Produit produit = dto.getProduit();
                    Machine machine = dto.getMachine();
                    if (produit == null || machine == null) {
                        return ResponseEntity.badRequest().body("Produit ou Machine introuvable");
                    }

                    OrdreFabrication toUpdate = ObjectMapperUtils.map(dto, OrdreFabrication.class);
                    toUpdate.setId(id);
                    toUpdate.setProduit(produit);
                    toUpdate.setMachine(machine);

                    OrdreFabrication updated = service.save(toUpdate);
                    return ResponseEntity.ok(ObjectMapperUtils.map(updated, OrdreFabricationDTO.class));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id).map(ordre -> {
            service.delete(id);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}