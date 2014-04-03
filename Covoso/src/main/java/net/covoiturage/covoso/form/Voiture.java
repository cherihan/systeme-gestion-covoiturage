package net.covoiturage.covoso.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	
	@Transient
	String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
