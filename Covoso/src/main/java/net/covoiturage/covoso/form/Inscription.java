package net.covoiturage.covoso.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Inscription")
public class Inscription {

	@Id
	@GeneratedValue
	@Column(name = "InscriptionID")
	Long inscriptionId;

	@Column(name = "AnnonceID")
	@ForeignKey(name = "AnnonceFK")
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
	@Transient
	String UtilisateurNom;
	@Transient
	String UtilisateurTelephone;
	public Long getInscriptionId() {
		return inscriptionId;
	}

	public void setInscriptionId(Long inscriptionId) {
		this.inscriptionId = inscriptionId;
	}

	public Long getAnnonceID() {
		return annonceID;
	}

	public String getUtilisateurNom() {
		return UtilisateurNom;
	}

	public void setUtilisateurNom(String utilisateurNom) {
		UtilisateurNom = utilisateurNom;
	}

	public String getUtilisateurTelephone() {
		return UtilisateurTelephone;
	}

	public void setUtilisateurTelephone(String utilisateurTelephone) {
		UtilisateurTelephone = utilisateurTelephone;
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
