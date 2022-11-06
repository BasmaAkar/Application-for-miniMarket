package org.lsi.market.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "lignesliv")
public class LigneLiv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_ligneliv;
	
	@Column(name = "quentite_livre", nullable = false)
	private int qte_liv;
	
	@ManyToOne
	@JoinColumn(name="COD_ART")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="NUM_LIV")
	private Livraison livraison;
	
	public LigneLiv() {
		
	}

	public LigneLiv(int num_ligneliv, int qte_liv) {
		super();
		this.num_ligneliv = num_ligneliv;
		this.qte_liv = qte_liv;
	}

	public int getNum_ligneliv() {
		return num_ligneliv;
	}

	public void setNum_ligneliv(int num_ligneliv) {
		this.num_ligneliv = num_ligneliv;
	}

	public int getQte_liv() {
		return qte_liv;
	}

	public void setQte_liv(int qte_liv) {
		this.qte_liv = qte_liv;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}
	
	
	
}