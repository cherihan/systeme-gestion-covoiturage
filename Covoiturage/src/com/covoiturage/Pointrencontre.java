package com.covoiturage;

import com.covoiturage.base.BasePointrencontre;

/**
 * This is the object class that relates to the pointrencontre table.
 * Any customizations belong here.
 */
public class Pointrencontre extends BasePointrencontre {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Pointrencontre () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Pointrencontre (java.lang.Integer _pointRencontreID) {
		super(_pointRencontreID);
	}

	/**
	 * Constructor for required fields
	 */
	public Pointrencontre (
		java.lang.Integer _pointRencontreID,
		com.covoiturage.Adresse _adresseID) {

		super (
			_pointRencontreID,
			_adresseID);
	}

/*[CONSTRUCTOR MARKER END]*/
}