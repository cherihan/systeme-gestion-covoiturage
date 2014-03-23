package net.covoiturage.covoso.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Inscription")
public class Inscription {

	@Id
	@Column(name = "InscriptionID")
	Long inscriptionId;

	@Column(name = "AnnonceID")
	@ForeignKey(name = "annoncefk")
	Long annonceID;

	@Column(name = "UtilisateurID")
	@ForeignKey(name = "Utilisateur_asso_AnnonceFK")
	Integer utilisateurID;

	@Column(name = "Nombreplace")
	Integer nombrePlace;

	@Column(name = "DateInscription")
	Date dateInscription;

	@Column(name = "Confirmer")
	int confirmer;

	public Long getInscriptionId() {
		return inscriptionId;
	}

	public void setInscriptionId(Long inscriptionId) {
		this.inscriptionId = inscriptionId;
	}

	public Long getAnnonceID() {
		return annonceID;
	}

	public void setAnnonceID(Long annonceID) {
		this.annonceID = annonceID;
	}

	public Integer getUtilisateurID() {
		return utilisateurID;
	}

	public void setUtilisateurID(Integer utilisateurID) {
		this.utilisateurID = utilisateurID;
	}

	public Integer getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Integer getConfirmer() {
		return confirmer;
	}

	public void setConfirmer(int confirmer) {
		this.confirmer = confirmer;
	}

}
