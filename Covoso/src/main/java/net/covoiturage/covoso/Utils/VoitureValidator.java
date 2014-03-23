package net.covoiturage.covoso.Utils;

import net.covoiturage.covoso.form.Voiture;
import net.covoiturage.covoso.service.VoitureService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VoitureValidator implements Validator {

	public boolean supports(Class clazz) {
		return Voiture.class.equals(clazz);
	}

	VoitureService cService;

	public void validate(Object target, Errors errors) {
		Voiture entity = (Voiture) target;

		if (entity.getType() == null) {
			errors.rejectValue("type", "*");
		}
		if (entity.getNombrePlace() == null) {
			errors.rejectValue("nombreplace", "*");
		}
	}
}
