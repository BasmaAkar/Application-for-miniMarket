package org.lsi.market.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Commande")
public class Commande implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCmd;
	private String dateCmd;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	
    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "commande")
	private Collection<Ligne_cmd> lignes_cmd  =new ArrayList<>();

	public Commande() {
		super();
	}

	public Commande(String date, Client client) {
		super();
		this.dateCmd = date;
	}


	public Long getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(Long numCmd) {
		this.numCmd = numCmd;
	}

	public String getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(String dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Ligne_cmd> getLignes_cmd() {
		return lignes_cmd;
	}

	public void setLignes_cmd(Collection<Ligne_cmd> lignes_cmd) {
		this.lignes_cmd = lignes_cmd;
	}
	
	
}
