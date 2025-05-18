package com.jihenjenhani.projetsgp.dto;

import com.jihenjenhani.projetsgp.entity.Machine;

public class TechnicienDTO {
    private Long id;
    private String nom;
    private String competences;
    private Machine machineAssignee;

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

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public Machine getMachineAssignee() {
        return machineAssignee;
    }

    public void setMachineAssignee(Machine machineAssignee) {
        this.machineAssignee = machineAssignee;
    }
}
