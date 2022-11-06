package org.lsi.market.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCli;
	private String nomCli;
	private String preCli;
	private String adrCli;
	private String telCli;
	private String villeCli;
	
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "client")
	private Collection<Commande> commandes= new ArrayList<>();

	public Client() {
		super();
	}

	public Client(Long codeCli, String nomCli, String preCli, String adrCli, String telCli, String villeCli,
			Collection<Commande> commandes) {
		super();
		this.codeCli = codeCli;
		this.nomCli = nomCli;
		this.preCli = preCli;
		this.adrCli = adrCli;
		this.telCli = telCli;
		this.villeCli = villeCli;
		this.commandes = commandes;
	}

	public Long getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(Long codeCli) {
		this.codeCli = codeCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPreCli() {
		return preCli;
	}

	public void setPreCli(String preCli) {
		this.preCli = preCli;
	}

	public String getAdrCli() {
		return adrCli;
	}

	public void setAdrCli(String adrCli) {
		this.adrCli = adrCli;
	}

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}

	public String getVilleCli() {
		return villeCli;
	}

	public void setVilleCli(String villeCli) {
		this.villeCli = villeCli;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	

	
}
