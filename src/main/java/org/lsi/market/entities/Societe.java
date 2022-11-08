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
@Table(name = "societes")
public class Societe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_ste;
	
	@Column(name = "nom_societe", nullable = false)
	private String nom_ste;
	
	
	@Column(name = "tel_societe")
	private String tel_ste;
	
	@Column(name = "fax_societe")
	private String fax_ste;
	
	@Column(name = "ville_stociete")
	private String ville_ste;
	
	@ManyToOne
	@JoinColumn(name="COD_FOUR")

	private Fournisseur fournisseur;
	
	public Societe() {
		
	}

	public Societe(Long cod_ste, String nom_ste, String tel_ste, String fax_ste, String ville_ste) {
		super();
		this.cod_ste = cod_ste;
		this.nom_ste = nom_ste;
		this.tel_ste = tel_ste;
		this.fax_ste = fax_ste;
		this.ville_ste = ville_ste;
	}

	public Long getCod_ste() {
		return cod_ste;
	}

	public void setCod_ste(Long cod_ste) {
		this.cod_ste = cod_ste;
	}

	public String getNom_ste() {
		return nom_ste;
	}

	public void setNom_ste(String nom_ste) {
		this.nom_ste = nom_ste;
	}

	public String getTel_ste() {
		return tel_ste;
	}

	public void setTel_ste(String tel_ste) {
		this.tel_ste = tel_ste;
	}

	public String getFax_ste() {
		return fax_ste;
	}

	public void setFax_ste(String fax_ste) {
		this.fax_ste = fax_ste;
	}

	public String getVille_ste() {
		return ville_ste;
	}

	public void setVille_ste(String ville_ste) {
		this.ville_ste = ville_ste;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Societe [nom_ste=" + nom_ste + ", tel_ste=" + tel_ste + ", ville_ste=" + ville_ste + "]";
	}

	
	
}