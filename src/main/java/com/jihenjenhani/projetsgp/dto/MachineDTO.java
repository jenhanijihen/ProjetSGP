package com.jihenjenhani.projetsgp.dto;

import java.time.LocalDate;
import java.util.Date;

public class MachineDTO {
    private Long id;
    private String nom;
    private String etat;
    private Date maintenanceProchaine;

    // Getters & Setters
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

    public Date getMaintenanceProchaine() {
        return maintenanceProchaine;
    }

    public void setMaintenanceProchaine(Date maintenanceProchaine) {
        this.maintenanceProchaine = maintenanceProchaine;
    }
}
