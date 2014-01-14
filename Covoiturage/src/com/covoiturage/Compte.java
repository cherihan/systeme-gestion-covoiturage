package com.covoiturage;

import com.covoiturage.base.BaseCompte;

/**
 * This is the object class that relates to the compte table.
 * Any customizations belong here.
 */
public class Compte extends BaseCompte {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Compte () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Compte (java.lang.String _login) {
		super(_login);
	}

	/**
	 * Constructor for required fields
	 */
	public Compte (
		java.lang.String _login,
		com.covoiturage.Utilisateur _utilisateurID) {

		super (
			_login,
			_utilisateurID);
	}
/*[CONSTRUCTOR MARKER END]*/
}