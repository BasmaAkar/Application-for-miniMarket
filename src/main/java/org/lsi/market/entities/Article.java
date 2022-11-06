package org.lsi.market.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Article")
public class Article implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeArt;
	private String nomArt;
	private float pu;
	private float qteStock;
	
	
	@OneToOne(mappedBy="article")
	private Ligne_cmd lignescmd;
	
    @OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST },mappedBy="article")
	private LigneLiv lignesliv;

	public Long getCodeArt() {
		return codeArt;
	}

	
	public Article() {
		super();
	}

	public Article(String nom_art, float prix, float quantitie, float pu, float qte_stock) {
		super();
		this.nomArt = nom_art;
		this.pu = pu;
		this.qteStock = qte_stock;
	}
	public void setCodeArt(Long codeArt) {
		this.codeArt = codeArt;
	}

	public String getNomArt() {
		return nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	public float getQteStock() {
		return qteStock;
	}

	public void setQteStock(float qteStock) {
		this.qteStock = qteStock;
	}

	public Ligne_cmd getLignescmd() {
		return lignescmd;
	}

	public void setLignescmd(Ligne_cmd lignescmd) {
		this.lignescmd = lignescmd;
	}

	public LigneLiv getLignesliv() {
		return lignesliv;
	}

	public void setLignesliv(LigneLiv lignesliv) {
		this.lignesliv = lignesliv;
	}

	

	
	public float getPu() {
		return pu;
	}

	public void setPu(float pu) {
		this.pu = pu;
	}


	@Override
	public String toString() {
		return " Nom de l'article :=" + nomArt + ", Quantité en stock :" + qteStock  ;
	}

}