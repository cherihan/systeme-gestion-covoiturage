package com.covoiturage;

import com.covoiturage.base.BaseAnnonce;

/**
 * This is the object class that relates to the annonce table.
 * Any customizations belong here.
 */
public class Annonce extends BaseAnnonce {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Annonce () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Annonce (java.lang.Integer _annonceID) {
		super(_annonceID);
	}

	/**
	 * Constructor for required fields
	 */
	public Annonce (
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