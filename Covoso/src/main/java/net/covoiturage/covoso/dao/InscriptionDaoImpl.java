package net.covoiturage.covoso.dao;

import java.util.List;

import net.covoiturage.covoso.form.Inscription;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("InscriptionDao")
public class InscriptionDaoImpl extends
		GenericDaoImpl<Inscription, Long> implements
		InscriptionDao {

	public List<Inscription> findbyAnnonceId(Long annonceID) {
		Query query = currentSession().createQuery("from Inscription where annonceid = :annonceID");
		query.setParameter("annonceID", annonceID);
		return query.list();
	}

}
