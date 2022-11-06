package org.lsi.market.dao;

import org.lsi.market.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ClientRepository extends JpaRepository<Client,Long>{

	



}
