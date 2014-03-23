package net.covoiturage.covoso.Utils;

import net.covoiturage.covoso.form.Compte;
import net.covoiturage.covoso.service.CompteService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CompteValidator implements Validator {

	public boolean supports(Class clazz) {
		return Compte.class.equals(clazz);
	}

	CompteService cService;
	public void validate(Object target, Errors errors) {
		Compte entity = (Compte) target;

		if (entity.getLogin() == null) {
			errors.rejectValue("login", "*");
			
		}
		else
		{
			if (cService.single(entity.getLogin()) != null) {
				errors.rejectValue("login", "Exist le nom de login");
			}
		}
		
		if (entity.getPassword() == null) {
			errors.rejectValue("prenom", "*");
		}
		if (entity.getPassword().length() < 6) {
			errors.rejectValue("password", "mot de passe > 6");
		}
	}

}
