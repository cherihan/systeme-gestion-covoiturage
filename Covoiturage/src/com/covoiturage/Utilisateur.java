package com.covoiturage;

import com.covoiturage.base.BaseUtilisateur;

/**
 * This is the object class that relates to the utilisateur table.
 * Any customizations belong here.
 */
public class Utilisateur extends BaseUtilisateur {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Utilisateur () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Utilisateur (java.lang.Integer _utilisateurID) {
		super(_utilisateurID);
	}

/*[CONSTRUCTOR MARKER END]*/
}