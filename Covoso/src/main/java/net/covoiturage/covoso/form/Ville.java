package net.covoiturage.covoso.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ville")
public class Ville {
	@Id
	@Column(name = "VilleID")
	@GeneratedValue
	Long villeID;

	@Column(name = "Nom")
	String nom;

	public Long getVilleID() {
		return villeID;
	}

	public void setVilleID(Long villeID) {
		this.villeID = villeID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
