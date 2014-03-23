package net.covoiturage.covoso.service;

import java.util.Date;
import java.util.List;

import net.covoiturage.covoso.dao.CompteDao;
import net.covoiturage.covoso.dao.UtilisateurDao;
import net.covoiturage.covoso.form.Compte;
import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.form.UtilisateuretCompte;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	protected UtilisateurDao udao;
	@Autowired
	protected CompteDao cdao;
	@Transactional
	public void create(String nom, String prenom, Date dateNaissance,
			String telephone, String email, Date dateCreate, Date dateUpdate) {
		Utilisateur user = new Utilisateur();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setDateNaissance(dateNaissance);
		user.setTelephone(telephone);
		user.setEmail(email);
		user.setDateCreate(dateCreate);
		user.setDateUpdate(dateUpdate);
		udao.add(user);
	}

	@Transactional
	public List<Utilisateur> all() {
		return (udao).list();
	}

	@Transactional
	public void delete(Utilisateur user) {
		udao.delete(user);
	}

	@Transactional
	public void remove(Integer id) {
		udao.remove(id);
	}

	@Transactional
	public void create(Utilisateur user) {
		udao.add(user);

	}

	@Transactional
	public Utilisateur single(int id) {
		return udao.single(id);
	}

	@Transactional
	public void update(Utilisateur user) {
		udao.update(user);
	}

	public int count() {
		return udao.count();
	}

	public List<Utilisateur> all(int page, int pagesize) {
		return udao.list(page, pagesize);
	}

	public void addUtilisateuretCompte(UtilisateuretCompte uc) {
		Utilisateur us = new Utilisateur();
		us.setNom(uc.getUtilisateur().getNom());
		us.setPrenom(uc.getUtilisateur().getPrenom());
		us.setEmail(uc.getUtilisateur().getEmail());
		us.setEmail(uc.getUtilisateur().getEmail());
		us.setDateCreate(uc.getUtilisateur().getDateCreate());
		us.setTelephone(uc.getUtilisateur().getTelephone());
		
		us.setDateCreate(new Date());
		us.setDateUpdate(new Date());
		
		udao.add(us);
		Criterion nom = Restrictions.like("nom", us.getNom());
		Criterion email = Restrictions.like("email", us.getEmail());
		LogicalExpression le = Restrictions.and(nom,email);
		us = udao.find(le).get(0);
		Compte cp = new Compte();
		cp.setLogin(uc.getCompte().getLogin());
		cp.setPassword(uc.getCompte().getPassword());
		cp.setType(uc.getCompte().getType());
		cp.setAvatar(uc.getCompte().getAvatar());
		cp.setUtilisateurid(us.getUtilisateurID());
		cdao.add(cp);
	}

	public Utilisateur findEmail(String email) {
		Criterion e = Restrictions.like("email", email);
		Criterion id = Restrictions.gt("utilisateurid", 0);
		LogicalExpression le = Restrictions.and(id,e);
		return udao.find(le).get(0);
	}

}
