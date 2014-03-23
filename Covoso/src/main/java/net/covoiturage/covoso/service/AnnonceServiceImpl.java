package net.covoiturage.covoso.service;

import java.util.Iterator;
import java.util.List;

import net.covoiturage.covoso.dao.AnnonceDao;
import net.covoiturage.covoso.dao.InscriptionDao;
import net.covoiturage.covoso.dao.VilleDao;
import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.form.Inscription;
import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.form.Ville;

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

	@Transactional
	public void createAnnonce(Annonce entity) {
		aDao.add(entity);
	}

	@Transactional
	public List<Annonce> allAnnonce() {
		return aDao.list();
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

	public List<Ville> allVille() {
		return vDao.list();
	}

	public Ville singleVille(Long key) {
		return vDao.single(key);
	}

	public int countAnnonceFind(Annonce rc) {
		return aDao.countAnnonceFind(rc);
	}

	public List<Annonce> listAnnonceFind(Annonce rc, int startpage, int pagesize) {
		return aDao.listAnnonceFind(rc, startpage, pagesize);
	}

	public int countAnnonceFindbyUtilisateur(Utilisateur us) {
		return aDao.countAnnonceFindbyUtilisateur(us);
	}

	public List<Annonce> listAnnonceFindbyUtilisateur(Utilisateur us,
			int startpage, int pagesize) {
		return aDao.listAnnonceFindbyUtilisateur(us, startpage, pagesize);
	}

}
