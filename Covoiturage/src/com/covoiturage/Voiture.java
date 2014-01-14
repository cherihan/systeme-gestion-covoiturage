package com.covoiturage;

import com.covoiturage.base.BaseVoiture;

/**
 * This is the object class that relates to the voiture table.
 * Any customizations belong here.
 */
public class Voiture extends BaseVoiture {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Voiture () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Voiture (java.lang.Integer _voitureID) {
		super(_voitureID);
	}

	/**
	 * Constructor for required fields
	 */
	public Voiture (
		java.lang.Integer _voitureID,
		com.covoiturage.Utilisateur _utilisateurID) {

		super (
			_voitureID,
			_utilisateurID);
	}

/*[CONSTRUCTOR MARKER END]*/
}