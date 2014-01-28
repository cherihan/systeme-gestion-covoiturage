package com.covoiturage;

import com.covoiturage.base.BaseRue;

/**
 * This is the object class that relates to the rue table.
 * Any customizations belong here.
 */
public class Rue extends BaseRue {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Rue () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Rue (java.lang.Integer _rueID) {
		super(_rueID);
	}

	/**
	 * Constructor for required fields
	 */
	public Rue (
		java.lang.Integer _rueID,
		com.covoiturage.Commune _communeID) {

		super (
			_rueID,
			_communeID);
	}

/*[CONSTRUCTOR MARKER END]*/
}