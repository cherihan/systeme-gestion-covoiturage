package net.covoiturage.covoso.Utils;

import net.covoiturage.covoso.form.Compte;
import net.covoiturage.covoso.service.CompteService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	public boolean supports(Class clazz) {
		return Compte.class.equals(clazz);
	}

	CompteService cService;

	public void validate(Object target, Errors errors) {
		Compte entity = (Compte) target;

		if (entity.getLogin() == null) {
			errors.rejectValue("login", "*");
		}
		if (entity.getPassword() == null) {
			errors.rejectValue("password", "*");
		}
	}

}
