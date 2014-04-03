package net.covoiturage.covoso.service;

import java.util.Date;
import java.util.List;

import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.form.UtilisateuretCompte;

public interface UtilisateurService {
	void create(String nom, String prenom, Date datanaissance,
			String telephone, String email, Date dateCreate, Date dateUpdate);

	void create(Utilisateur user);

	List<Utilisateur> all();

	void update(Utilisateur user);

	Utilisateur single(Integer id);

	void remove(Integer id);

	void delete(Utilisateur u);

	int count();

	List<Utilisateur> all(int page, int pagesize);
	
	void addUtilisateuretCompte(UtilisateuretCompte uc);
	void updateUtilisateuretCompte(UtilisateuretCompte uc,Utilisateur user);
	Utilisateur findEmail(String email);
}
