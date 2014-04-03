package net.covoiturage.covoso.dao;

import java.util.Date;
import java.util.List;

import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.form.Utilisateur;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.annotations.Parameter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("AnnonceDao")
public class AnnonceDaoImpl extends GenericDaoImpl<Annonce, Long> implements
		AnnonceDao {
	public int countAnnonceFind(Annonce rc) {
		Criteria criteria = currentSession().createCriteria(daoType);
		Criterion rc1 = Restrictions.like("endroitDepart",
				rc.getEndroitDepart());
		Criterion rc2 = Restrictions.like("endroitArrivee",
				rc.getEndroitArrivee());
		Criterion rc3 = Restrictions.like("dateDepart", rc.getDateDepart());
		Criterion rc4 = Restrictions.eq("villeArrivee", rc.getVilleArrivee());
		Criterion rc5 = Restrictions.eq("villeDepart", rc.getVilleDepart());
		Criterion rc6 = Restrictions.like("heureDepart", rc.getHeureDepart());
		criteria.add(rc1).add(rc2).add(rc3).add(rc4).add(rc5).add(rc6);

		criteria.setProjection(Projections.rowCount());
		return ((Long) criteria.uniqueResult()).intValue();
	}

	public List<Annonce> listAnnonceFindAll(Annonce rc) {
		Query query = null;
		String con = " 1=1 ";
		Boolean isPara1 = false, isPara2 = false, isPara3 = false, isPara4 = false, isPara5 = false, isPara6 = false;
		if (rc.getEndroitDepart()!="") {
			con += " and endroitdepart like :endroitDepart ";
			isPara1 = true;
		}
		if (rc.getEndroitArrivee()!="") {
			con += " and endroitarrivee like :endroitArrivee ";
			isPara2 = true;
		}
		if (rc.getVilleDepart() != null) {
			con += " and villedepart = :villeDepart ";
			isPara3 = true;
		}
		if (rc.getVilleArrivee() != null) {
			con += "and villeArrivee = :villeArrivee ";
			isPara4 = true;
		}
		if (rc.getDateDepart()!=null) {
			con += "and dateDepart like :dateDepart ";
			isPara5 = true;
		}
		if (rc.getHeureDepart()!="") {
			con += "and heureDepart = :heureDepart ";
			isPara6 = true;
		}
		query = currentSession().createQuery("from Annonce where " + con);
		if (isPara1)
			query.setParameter("endroitDepart", rc.getEndroitDepart());
		if (isPara2)
			query.setParameter("endroitArrivee", rc.getEndroitArrivee());
		if (isPara3)
			query.setParameter("villeDepart", rc.getVilleDepart());
		if (isPara4)
			query.setParameter("villeArrivee", rc.getVilleArrivee());
		if (isPara5)
			query.setParameter("dateDepart", rc.getDateDepart());
		if (isPara6)
			query.setParameter("heureDepart", rc.getHeureDepart());
		return query.list();
	}

	public List<Annonce> listAnnonceFind(Annonce rc, int startpage, int pagesize) {
		if (startpage > 0)
			--startpage;
		int firsResult = startpage * pagesize;
		Criteria criteria = currentSession().createCriteria(daoType);
		Criterion rc1 = Restrictions.like("endroitDepart",
				rc.getEndroitDepart());
		Criterion rc2 = Restrictions.like("endroitArrivee",
				rc.getEndroitArrivee());
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
