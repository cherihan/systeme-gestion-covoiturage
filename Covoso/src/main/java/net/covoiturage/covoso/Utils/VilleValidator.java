package net.covoiturage.covoso.Utils;

import net.covoiturage.covoso.form.Ville;
import net.covoiturage.covoso.form.Voiture;
import net.covoiturage.covoso.service.VoitureService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VilleValidator implements Validator {

	public boolean supports(Class clazz) {
		return Ville.class.equals(clazz);
	}

	VoitureService cService;

	public void validate(Object target, Errors errors) {
		Ville entity = (Ville) target;
		if (entity.getNom().length()<1) {
			errors.rejectValue("nom", "*");
		}
	}
}
