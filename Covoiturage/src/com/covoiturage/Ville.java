package com.covoiturage;

import com.covoiturage.base.BaseVille;

/**
 * This is the object class that relates to the ville table.
 * Any customizations belong here.
 */
public class Ville extends BaseVille {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Ville () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Ville (java.lang.Integer _villeID) {
		super(_villeID);
	}

/*[CONSTRUCTOR MARKER END]*/
}