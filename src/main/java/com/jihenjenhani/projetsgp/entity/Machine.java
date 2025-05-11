package com.jihenjenhani.projetsgp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String etat;
    private LocalDate maintenanceProchaine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public LocalDate getMaintenanceProchaine() {
        return maintenanceProchaine;
    }

    public void setMaintenanceProchaine(LocalDate maintenanceProchaine) {
        this.maintenanceProchaine = maintenanceProchaine;
    }
}
