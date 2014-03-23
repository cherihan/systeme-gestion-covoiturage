package net.covoiturage.covoso.Utils;

import net.covoiturage.covoso.form.Compte;
import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.form.UtilisateuretCompte;
import net.covoiturage.covoso.service.CompteService;
import net.covoiturage.covoso.service.UtilisateurService;

import org.springframework.validation.Errors;

public class UtilisateuretCompteValidator {
	public boolean supports(Class clazz) {
		return UtilisateuretCompte.class.equals(clazz);
	}

	CompteService cService;
	UtilisateurService uservice;

	public void validate(Object target, Errors errors) {
		UtilisateuretCompte entity = (UtilisateuretCompte) target;
		Utilisateur user = entity.getUtilisateur();
		Compte comp = entity.getCompte();
		if (comp != null) {
			if (comp.getLogin() == null) {
				errors.rejectValue("login", "*");
			}
			else
			{
				if (cService.single(comp.getLogin()) != null) {
					errors.rejectValue("login", "Exist le nom de login");
				}
			}
			if (comp.getPassword() == null) {
				errors.rejectValue("prenom", "*");
			}
			if (comp.getPassword().length() < 6) {
				errors.rejectValue("password", "mot de passe > 6");
			}
		} else if (user != null) {
			if (user.getNom() == null) {
				errors.rejectValue("nom", "*");
			}
			if (user.getPrenom() == null) {
				errors.rejectValue("prenom", "*");
			}
			if (user.getTelephone() == null) {
				errors.rejectValue("telephone", "*");
			}
			if (user.getEmail() == null) {
				errors.rejectValue("email", "*");
			}
			if (uservice.findEmail(user.getEmail()) != null) {
				errors.rejectValue("email", "Existe ce mel");
			}
		}
	}
}
