package com.covoiturage;

import com.covoiturage.base.BaseAdresse;

/**
 * This is the object class that relates to the adresse table.
 * Any customizations belong here.
 */
public class Adresse extends BaseAdresse {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Adresse () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Adresse (java.lang.Integer _adresseID) {
		super(_adresseID);
	}

	/**
	 * Constructor for required fields
	 */
	public Adresse (
		java.lang.Integer _adresseID,
		com.covoiturage.Ville _villeID) {

		super (
			_adresseID,
			_villeID);
	}

/*[CONSTRUCTOR MARKER END]*/
}