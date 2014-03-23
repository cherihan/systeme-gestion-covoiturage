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
@Table(name = "Annonce")
public class Annonce {
	@Id
	@GeneratedValue
	@Column(name = "AnnonceID")
	Long annonceID;

	@Column(name = "VilleDepart")
	@ForeignKey(name = "VilleDepartFK")
	Long villeDepart;

	@Column(name = "EndroitDepart")
	String endroitDepart;

	@Column(name = "VilleArrivee")
	@ForeignKey(name = "VilleArriveeFK")
	Long villeArrivee;

	@Column(name = "EndroitArrivee")
	String endroitArrivee;

	@Column(name = "titre")
	String titre;

	@Column(name = "description")
	String description;

	@Column(name = "dateDepart")
	Date dateDepart;

	@Column(name = "heureDepart")
	String heureDepart;

	@Column(name = "totalTemp")
	String totalTemp;

	@Column(name = "Prix")
	String prix;

	@Column(name = "nombrePlace")
	int nombrePlace;

	@Column(name = "autresEndroitsPasses")
	String autresEndroitsPasses;

	@Column(name = "voitureID")
	@ForeignKey(name = "voitureFK")
	Long voitureID;

	@Column(name = "utilisateurID")
	@ForeignKey(name = "Utilisateur_AnnonceFK")
	Integer utilisateurID;

	@Column(name = "dateCreate")
	Date dateCreate;
	
	
	@Transient
	String villeArriveeNom;
	@Transient
	String villeDepartNom;
	
	public String getVilleArriveeNom() {
		return villeArriveeNom;
	}

	public String getVilleDepartNom() {
		return villeDepartNom;
	}

	public void setVilleArriveeNom(String villeArriveNom) {
		this.villeArriveeNom = villeArriveNom;
	}

	public void setVilleDepartNom(String villeDepartNom) {
		this.villeDepartNom = villeDepartNom;
	}

	public Long getAnnonceID() {
		return annonceID;
	}

	public void setAnnonceID(Long annonceID) {
		this.annonceID = annonceID;
	}

	public Long getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(Long villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getEndroitDepart() {
		return endroitDepart;
	}

	public void setEndroitDepart(String endroitDepart) {
		this.endroitDepart = endroitDepart;
	}

	public Long getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(Long villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public String getEndroitArrivee() {
		return endroitArrivee;
	}

	public void setEndroitArrivee(String endroitArrivee) {
		this.endroitArrivee = endroitArrivee;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getTotalTemp() {
		return totalTemp;
	}

	public void setTotalTemp(String totalTemp) {
		this.totalTemp = totalTemp;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public String getAutresEndroitsPasses() {
		return autresEndroitsPasses;
	}

	public void setAutresEndroitsPasses(String autresEndroitsPasses) {
		this.autresEndroitsPasses = autresEndroitsPasses;
	}

	public Long getVoitureID() {
		return voitureID;
	}

	public void setVoitureID(Long voitureID) {
		this.voitureID = voitureID;
	}

	public Integer getUtilisateurID() {
		return utilisateurID;
	}

	public void setUtilisateurID(Integer utilisateurID) {
		this.utilisateurID = utilisateurID;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
