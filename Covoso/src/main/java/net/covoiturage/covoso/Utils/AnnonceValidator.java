package net.covoiturage.covoso.Utils;

import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.service.AnnonceService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AnnonceValidator implements Validator {

	public boolean supports(Class clazz) {
		return Annonce.class.equals(clazz);
	}

	AnnonceService cService;
	public void validate(Object target, Errors errors) {
		Annonce entity = (Annonce) target;

		if (entity.getTitre() == null||entity.getTitre()=="") {
			errors.rejectValue("titre", "*");
		}
		
		if (entity.getDateDepart() == null) {
			errors.rejectValue("dateDepart", "*");
		}
		if (entity.getHeureDepart()==null) {
			errors.rejectValue("heureDepart", "*");
		}
	}

}
