package net.covoiturage.covoso.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
	
	@Id
	@Column(name="UtilisateurID")
	@GeneratedValue
	Integer utilisateurID;
	
	@Column(name="Nom")
	String nom;
	
	@Column(name="Prenom")
	String prenom;
	
	@Column(name="DateNaissance")
	Date dateNaissance;
	
	@Column(name="Telephone")
	String telephone;


	@Column(name="Email")
	String email;
	
	@Column(name="DateCreate")
	Date dateCreate;
	
	@Column(name="DateUpdate")
	Date dateUpdate;
	
	
	public Integer getUtilisateurID() {
		return utilisateurID;
	}

	public void setUtilisateurID(Integer utilisateurID) {
		this.utilisateurID = utilisateurID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
}
