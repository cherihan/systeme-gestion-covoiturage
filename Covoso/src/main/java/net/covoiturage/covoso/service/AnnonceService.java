package net.covoiturage.covoso.service;

import java.util.List;

import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.form.Inscription;
import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.form.Ville;


public interface AnnonceService {
	// Ville
	List<Ville> allVille();
	Ville singleVille(Long key);
	// Annonce
	void createAnnonce(Annonce entity);

	List<Annonce> allAnnonce();

	void updateAnnonce(Annonce entity);

	Annonce singleAnnonce(Long id);

	void removeAnnonce(Long id);

	void deleteAnnonce(Annonce entity);

	int countAnnonce();

	List<Annonce> allAnnonce(int page, int pagesize); // Annonce_Utilisateur
	
	int countAnnonceFind(Annonce rc);
	List<Annonce> listAnnonceFind(Annonce rc, int page, int pagezize);

	void createAnnonceUtilisateur(Inscription entity);

	List<Inscription> allAnnonceUtilisateur();

	void updateAnnonceUtilisateur(Inscription entity);

	Inscription singleAnnonceUtilisateur(Long id);

	void removeAnnonceUtilisateur(Long id);

	void deleteAnnonceUtilisateur(Inscription entity);

	int countAnnonceUtilisateur();

	List<Inscription> allAnnonceUtilisateur(int page, int pagesize);
	int countAnnonceFindbyUtilisateur(Utilisateur us);
	List<Annonce> listAnnonceFindbyUtilisateur(Utilisateur us, int startpage, int pagesize);


}
