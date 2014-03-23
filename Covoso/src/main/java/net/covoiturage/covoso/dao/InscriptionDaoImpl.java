package net.covoiturage.covoso.dao;

import net.covoiturage.covoso.form.Inscription;

import org.springframework.stereotype.Repository;

@Repository("InscriptionDao")
public class InscriptionDaoImpl extends
		GenericDaoImpl<Inscription, Long> implements
		InscriptionDao {

}
