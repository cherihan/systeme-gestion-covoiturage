package net.covoiturage.covoso.Utils;

import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.service.UtilisateurService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UtilisateurValidator implements Validator {

	public boolean supports(Class clazz) {
		return Utilisateur.class.equals(clazz);
	}
	UtilisateurService uservice;
	public void validate(Object target, Errors errors) {
		Utilisateur user = (Utilisateur) target;

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
		if (user.getEmail() == null) {
			errors.rejectValue("email", "*");
		}
		if (uservice.findEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Existe ce mel");
		}

		// do "complex" validation here

	}

}
