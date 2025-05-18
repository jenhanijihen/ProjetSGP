package com.jihenjenhani.projetsgp.dto;


import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.entity.Technicien;

import java.util.Date;

public class MaintenanceDTO {
    private Long id;
    private Machine machine;
    private Technicien technicien;
    private Date date;
    private String type;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Technicien getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
