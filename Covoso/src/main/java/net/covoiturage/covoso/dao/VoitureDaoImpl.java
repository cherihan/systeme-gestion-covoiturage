package net.covoiturage.covoso.dao;

import net.covoiturage.covoso.form.Voiture;

import org.springframework.stereotype.Repository;

@Repository("VoitureDao")
public class VoitureDaoImpl extends GenericDaoImpl<Voiture, Long> implements
		VoitureDao {

}