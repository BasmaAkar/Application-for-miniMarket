package org.lsi.market.dao;


import org.lsi.market.entities.Ligne_cmd;
import org.lsi.market.entities.Primarykey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  Ligne_cmdRepository extends JpaRepository<Ligne_cmd,Primarykey>{

	
	Ligne_cmd findByNumLigne(Long numLigne);
}
