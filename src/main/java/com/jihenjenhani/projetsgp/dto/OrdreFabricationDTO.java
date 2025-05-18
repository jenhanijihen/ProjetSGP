package com.jihenjenhani.projetsgp.dto;

import com.jihenjenhani.projetsgp.entity.Machine;
import com.jihenjenhani.projetsgp.entity.Produit;
import com.jihenjenhani.projetsgp.entity.StatutOrdre;

import java.util.Date;

public class OrdreFabricationDTO {
    private Long id;
    private Produit produit;
    private Machine machine;

    private int quantite;
    private Date date;
    private StatutOrdre statut;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatutOrdre getStatut() {
        return statut;
    }

    public void setStatut(StatutOrdre statut) {
        this.statut = statut;
    }

}