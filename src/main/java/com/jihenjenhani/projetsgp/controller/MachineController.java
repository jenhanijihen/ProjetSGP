package com.jihenjenhani.projetsgp.controller;

import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.service.MachineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
@CrossOrigin("*")
public class MachineController {
    private final MachineService service;

    public MachineController(MachineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Machine> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Machine create(@RequestBody Machine machine) {
        return service.save(machine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> update(@PathVariable Long id, @RequestBody Machine machine) {
        return service.findById(id)
                .map(existing -> {
                    machine.setId(id);
                    return ResponseEntity.ok(service.save(machine));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}