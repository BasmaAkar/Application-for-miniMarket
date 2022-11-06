package org.lsi.market.dao;

import org.lsi.market.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CommandeRepository extends JpaRepository<Commande,Long>{

}
