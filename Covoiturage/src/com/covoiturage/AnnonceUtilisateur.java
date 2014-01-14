package com.covoiturage;

import com.covoiturage.base.BaseAnnonceUtilisateur;

/**
 * This is the object class that relates to the annonce_utilisateur table.
 * Any customizations belong here.
 */
public class AnnonceUtilisateur extends BaseAnnonceUtilisateur {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AnnonceUtilisateur () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AnnonceUtilisateur (java.lang.Integer _annonceID) {
		super(_annonceID);
	}

	/**
	 * Constructor for required fields
	 */
	public AnnonceUtilisateur (
		java.lang.Integer _annonceID,
		com.covoiturage.Utilisateur _utilisateurID,
		com.covoiturage.Pointrencontre _pointDepartID,
		com.covoiturage.Pointrencontre _pointArriveeID) {

		super (
			_annonceID,
			_utilisateurID,
			_pointDepartID,
			_pointArriveeID);
	}

/*[CONSTRUCTOR MARKER END]*/
}