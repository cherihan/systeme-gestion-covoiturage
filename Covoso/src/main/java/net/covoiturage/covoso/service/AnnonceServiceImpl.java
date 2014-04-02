package net.covoiturage.covoso.service;

import java.util.List;

import net.covoiturage.covoso.dao.AnnonceDao;
import net.covoiturage.covoso.dao.InscriptionDao;
import net.covoiturage.covoso.dao.VilleDao;
import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.form.Inscription;
import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.form.Ville;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnonceServiceImpl implements AnnonceService {

	// Annonce
	@Autowired
	protected AnnonceDao aDao;
	@Autowired
	protected VilleDao vDao;
	@Autowired
	protected InscriptionDao iDao;

	@Transactional
	public void createAnnonce(Annonce entity) {
		aDao.add(entity);
	}

	@Transactional
	public List<Annonce> allAnnonce() {
		List<Annonce> result =  aDao.list();
		for (int i=0;i<result.size();i++) {
			result.get(i).setVilleArriveeNom(vDao.single(result.get(i).getVilleArrivee()).getNom());
			result.get(i).setVilleDepartNom(vDao.single(result.get(i).getVilleDepart()).getNom());
		}
		return result;
	}

	@Transactional
	public void updateAnnonce(Annonce entity) {
		aDao.update(entity);
	}

	@Transactional
	public Annonce singleAnnonce(Long id) {
		return aDao.single(id);
	}

	@Transactional
	public void removeAnnonce(Long id) {
		aDao.remove(id);
	}

	@Transactional
	public void deleteAnnonce(Annonce entity) {
		aDao.delete(entity);
	}

	@Transactional
	public int countAnnonce() {
		return aDao.count();
	}

	@Transactional
	public List<Annonce> allAnnonce(int page, int pagesize) {
		List<Annonce> result = aDao.list(page, pagesize);
		for (int i=0;i<result.size();i++) {
			result.get(i).setVilleArriveeNom(vDao.single(result.get(i).getVilleArrivee()).getNom());
			result.get(i).setVilleDepartNom(vDao.single(result.get(i).getVilleDepart()).getNom());
		}
		return result;
	}

	// AnnonceUtilisateur
	@Autowired
	protected InscriptionDao auDao;

	@Transactional
	public void createAnnonceUtilisateur(Inscription entity) {
		auDao.add(entity);
	}

	@Transactional
	public List<Inscription> allAnnonceUtilisateur() {
		return auDao.list();
	}

	@Transactional
	public void updateAnnonceUtilisateur(Inscription entity) {
		auDao.update(entity);
	}

	@Transactional
	public Inscription singleAnnonceUtilisateur(Long id) {
		return auDao.single(id);
	}

	@Transactional
	public void removeAnnonceUtilisateur(Long id) {
		auDao.remove(id);
	}

	@Transactional
	public void deleteAnnonceUtilisateur(Inscription entity) {
		auDao.delete(entity);
	}

	@Transactional
	public int countAnnonceUtilisateur() {
		return auDao.count();
	}

	@Transactional
	public List<Inscription> allAnnonceUtilisateur(int page, int pagesize) {
		return auDao.list(page, pagesize);
	}
	@Transactional
	public List<Ville> allVille() {
		return vDao.list();
	}
	@Transactional
	public Ville singleVille(Long key) {
		return vDao.single(key);
	}
	@Transactional
	public int countAnnonceFind(Annonce rc) {
		return aDao.countAnnonceFind(rc);
	}
	@Transactional
	public List<Annonce> listAnnonceFind(Annonce rc, int startpage, int pagesize) {
		return aDao.listAnnonceFind(rc, startpage, pagesize);
	}
	@Transactional
	public int countAnnonceFindbyUtilisateur(Utilisateur us) {
		return aDao.countAnnonceFindbyUtilisateur(us);
	}
	@Transactional
	public List<Annonce> listAnnonceFindbyUtilisateur(Utilisateur us,
			int startpage, int pagesize) {
		return aDao.listAnnonceFindbyUtilisateur(us, startpage, pagesize);
	}
	@Transactional
	public void updateVille(Ville entity) {
		vDao.update(entity);
	}
	@Transactional
	public void removeVille(Long id) {
		vDao.remove(id);
	}
	@Transactional
	public void deleteVille(Ville entity) {
		vDao.delete(entity);
	}
	@Transactional
	public int countVille() {
		return vDao.count();
	}
	@Transactional
	public List<Ville> allVille(int page, int pagesize) {
		return vDao.list(page, pagesize);
	}
	@Transactional
	public void createVille(Ville entity) {
		vDao.add(entity);
	}
	@Transactional
	public List<Inscription> findbyAnnonce(Long annonceID) {
		Criterion e = Restrictions.eq("annonceID", annonceID);
		Criterion id = Restrictions.gt("inscriptionId", new Long(0));
		LogicalExpression le = Restrictions.and(id,e);
		return iDao.find(le);
	}
	@Transactional
	public List<Inscription> findbyUtilisateur(Integer utilisateurID) {
		Criterion e = Restrictions.eq("utilisateurID", utilisateurID);
		Criterion id = Restrictions.gt("inscriptionId", new Long(0));
		LogicalExpression le = Restrictions.and(id,e);
		return iDao.find(le);
	}
	@Transactional
	public void createInscription(Inscription entity) {
		iDao.add(entity);
	}
	@Transactional
	public List<Inscription> allInscription() {
		return iDao.list();
	}
	@Transactional
	public void updateInscription(Inscription entity) {
		iDao.update(entity);
	}
	@Transactional
	public Inscription singleInscription(Long id) {
		return iDao.single(id);
	}
	@Transactional
	public void removeInscription(Long id) {
		iDao.remove(id);
	}
	@Transactional
	public void deleteInscription(Inscription entity) {
		iDao.delete(entity);
	}
	@Transactional
	public Boolean hasInscription(Long annonceID, Integer utilisateurID) {
		Criterion e = Restrictions.eq("utilisateurID", utilisateurID);
		Criterion id = Restrictions.eq("annonceID", annonceID);
		LogicalExpression le = Restrictions.and(id,e);
		return iDao.find(le).size()==0?false:true;
	}

	public List<Annonce> listAnnonceFindAll(Annonce rc) {
		List<Annonce> result =  aDao.listAnnonceFindAll(rc);
		for (int i=0;i<result.size();i++) {
			result.get(i).setVilleArriveeNom(vDao.single(result.get(i).getVilleArrivee()).getNom());
			result.get(i).setVilleDepartNom(vDao.single(result.get(i).getVilleDepart()).getNom());
		}
		return result;
	}
}
