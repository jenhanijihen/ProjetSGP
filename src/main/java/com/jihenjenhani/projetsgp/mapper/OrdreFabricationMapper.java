package com.jihenjenhani.projetsgp.mapper;

import com.jihenjenhani.projetsgp.dto.OrdreFabricationDTO;
import com.jihenjenhani.projetsgp.entity.OrdreFabrication;

public class OrdreFabricationMapper {

    public static OrdreFabricationDTO toDTO(OrdreFabrication entity) {
        OrdreFabricationDTO dto = new OrdreFabricationDTO();
        dto.setId(entity.getId());
        dto.setQuantite(entity.getQuantite());
        dto.setDate(entity.getDate());
        dto.setStatut(entity.getStatut());

        if (entity.getProduit() != null) {
            dto.setProduitId(entity.getProduit().getId());
        }
        if (entity.getMachine() != null) {
            dto.setMachineId(entity.getMachine().getId());
        }
        return dto;
    }

    public static OrdreFabrication toEntity(OrdreFabricationDTO dto, Produit produit, Machine machine) {
        OrdreFabrication entity = new OrdreFabrication();
        entity.setId(dto.getId());
        entity.setQuantite(dto.getQuantite());
        entity.setDate(dto.getDate());
        entity.setStatut(dto.getStatut());
        entity.setProduit(produit);
        entity.setMachine(machine);
        return entity;
    }
}
