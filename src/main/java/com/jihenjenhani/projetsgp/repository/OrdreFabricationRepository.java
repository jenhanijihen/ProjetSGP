package com.jihenjenhani.projetsgp.repository;

import com.jihenjenhani.projetsgp.entity.OrdreFabrication;
import com.jihenjenhani.projetsgp.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdreFabricationRepository extends JpaRepository<OrdreFabrication, Long> {
    boolean existsByProduit(Produit produit);

}
