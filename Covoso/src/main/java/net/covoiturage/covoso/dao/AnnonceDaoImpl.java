package net.covoiturage.covoso.dao;

import java.util.List;

import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.form.Utilisateur;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("AnnonceDao")
public class AnnonceDaoImpl extends GenericDaoImpl<Annonce, Long> implements
		AnnonceDao {
	public int countAnnonceFind(Annonce rc) {
		Criteria criteria = currentSession().createCriteria(daoType);
		Criterion rc1 = Restrictions.like("endroitDepart", rc.getEndroitDepart());
		Criterion rc2 = Restrictions.like("endroitArrivee", rc.getEndroitArrivee());
		Criterion rc3 = Restrictions.like("dateDepart", rc.getDateDepart());
		Criterion rc4 = Restrictions.eq("villeArrivee", rc.getVilleArrivee());
		Criterion rc5 = Restrictions.eq("villeDepart", rc.getVilleDepart());
		Criterion rc6 = Restrictions.like("heureDepart", rc.getHeureDepart());
		criteria.add(rc1).add(rc2).add(rc3).add(rc4).add(rc5).add(rc6);
				
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.uniqueResult()).intValue();
	}

	public List<Annonce> listAnnonceFind (Annonce rc, int startpage, int pagesize) {
		if (startpage > 0)
			--startpage;
		int firsResult = startpage * pagesize;
		Criteria criteria = currentSession().createCriteria(daoType);
		Criterion rc1 = Restrictions.like("endroitDepart", rc.getEndroitDepart());
		Criterion rc2 = Restrictions.like("endroitArrivee", rc.getEndroitArrivee());
		Criterion rc3 = Restrictions.like("dateDepart", rc.getDateDepart());
		Criterion rc4 = Restrictions.eq("villeArrivee", rc.getVilleArrivee());
		Criterion rc5 = Restrictions.eq("villeDepart", rc.getVilleDepart());
		Criterion rc6 = Restrictions.like("heureDepart", rc.getHeureDepart());
		criteria.add(rc1).add(rc2).add(rc3).add(rc4).add(rc5).add(rc6);
	
		criteria.setFirstResult(firsResult);
		criteria.setMaxResults(pagesize);
		return criteria.list();
	}

	public int countAnnonceFindbyUtilisateur(Utilisateur us) {
		Criteria criteria = currentSession().createCriteria(daoType);
		Criterion rc1 = Restrictions.eq("utilisateurID", us.getUtilisateurID());
		criteria.add(rc1);
				
		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.uniqueResult()).intValue();
	}

	public List<Annonce> listAnnonceFindbyUtilisateur(Utilisateur us,
			int startpage, int pagesize) {
		if (startpage > 0)
			--startpage;
		int firsResult = startpage * pagesize;
		Criteria criteria = currentSession().createCriteria(daoType);
		Criterion rc1 = Restrictions.eq("utilisateurID", us.getUtilisateurID());
		criteria.add(rc1);
	
		criteria.setFirstResult(firsResult);
		criteria.setMaxResults(pagesize);
		return criteria.list();
	}
}
