package net.covoiturage.covoso.dao;

import net.covoiturage.covoso.form.Compte;

import org.springframework.stereotype.Repository;

@Repository("CompteDao")
public class CompteDaoImpl extends GenericDaoImpl<Compte, String> implements
		CompteDao {

}
