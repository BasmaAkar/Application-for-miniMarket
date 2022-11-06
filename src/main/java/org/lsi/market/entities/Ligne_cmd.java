package org.lsi.market.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@IdClass(Primarykey.class)
@Table(name="Ligne_cmd")
public class Ligne_cmd implements Serializable{

	@Id
	private Long numLigne;
	
	
	@Id
	@OneToOne 
	@JoinColumn(name="CODE_ART")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="NUM_CMD")
	private Commande commande;
	private int qteCmd;
	public Ligne_cmd() {
		super();
	}

	public Ligne_cmd(int qte_cmd) {
		super();
		this.qteCmd = qte_cmd;
	}

	
	public Long getNumLigne() {
		return numLigne;
	}

	public void setNumLigne(Long numLigne) {
		this.numLigne = numLigne;
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
