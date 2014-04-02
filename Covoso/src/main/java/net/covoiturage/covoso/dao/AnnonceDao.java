package net.covoiturage.covoso.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.form.Utilisateur;

public interface AnnonceDao extends GenericDao<Annonce, Long> {
	int countAnnonceFind(Annonce rc);
	List<Annonce> listAnnonceFind(Annonce rc, int startpage, int pagesize);
	int countAnnonceFindbyUtilisateur(Utilisateur us);
	List<Annonce> listAnnonceFindbyUtilisateur(Utilisateur us, int startpage, int pagesize);
	List<Annonce>  listAnnonceFindAll(Annonce rc);
}
