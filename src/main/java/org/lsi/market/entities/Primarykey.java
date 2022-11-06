package org.lsi.market.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Primarykey  implements Serializable{
	
	private Long numLigne;

	public Long getNumligne() {
		return numLigne;
	}

	public void setNumligne(Long numligne) {
		this.numLigne = numligne;
	}


}
