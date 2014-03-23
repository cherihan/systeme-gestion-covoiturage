package net.covoiturage.covoso.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Voiture")
public class Voiture {

	@Id
	@Column(name = "VoitureID")
	@GeneratedValue
	Long voitureID;

	@Column(name = "type")
	String type;

	@Column(name = "NombrePlace")
	Integer nombrePlace;

	// @OneToOne()
	@Column(name = "UtilisateurID")
	@ForeignKey(name = "Utilisateur_VoitureFK")
	Integer utilisateurID;




	public Long getVoitureID() {
		return voitureID;
	}

	public void setVoitureID(Long voitureID) {
		this.voitureID = voitureID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public Integer getUtilisateurID() {
		return utilisateurID;
	}

	public void setUtilisateurID(Integer utilisateurID) {
		this.utilisateurID = utilisateurID;
	}
	/*
	 * Utilisateur utilisateur; public Utilisateur getUtilisateur() { if
	 * (utilisateur == null && utilisateurID != null) return new
	 * UtilisateurDaoImpl().single(this.getUtilisateurID()); else return
	 * utilisateur; }
	 * 
	 * public void setUtilisateur(Integer utilisateur) { this.utilisateur = new
	 * UtilisateurDaoImpl().single(this .getUtilisateurID()); }
	 */
}
