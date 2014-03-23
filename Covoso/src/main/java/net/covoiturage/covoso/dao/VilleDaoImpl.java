package net.covoiturage.covoso.dao;

import net.covoiturage.covoso.form.Ville;

import org.springframework.stereotype.Repository;

@Repository("VilleDao")
public class VilleDaoImpl extends GenericDaoImpl<Ville, Long> implements
		VilleDao {

}
