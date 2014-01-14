package com.covoiturage;

import com.covoiturage.base.BaseCommune;

/**
 * This is the object class that relates to the commune table.
 * Any customizations belong here.
 */
public class Commune extends BaseCommune {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Commune () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Commune (java.lang.Integer _communeID) {
		super(_communeID);
	}

	/**
	 * Constructor for required fields
	 */
	public Commune (
		java.lang.Integer _communeID,
		com.covoiturage.District _districtID) {

		super (
			_communeID,
			_districtID);
	}

/*[CONSTRUCTOR MARKER END]*/
}