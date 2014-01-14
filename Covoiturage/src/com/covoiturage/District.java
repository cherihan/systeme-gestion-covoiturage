package com.covoiturage;

import com.covoiturage.base.BaseDistrict;

/**
 * This is the object class that relates to the district table.
 * Any customizations belong here.
 */
public class District extends BaseDistrict {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public District () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public District (java.lang.Integer _districtID) {
		super(_districtID);
	}

	/**
	 * Constructor for required fields
	 */
	public District (
		java.lang.Integer _districtID,
		com.covoiturage.Ville _villeID) {

		super (
			_districtID,
			_villeID);
	}

/*[CONSTRUCTOR MARKER END]*/
}