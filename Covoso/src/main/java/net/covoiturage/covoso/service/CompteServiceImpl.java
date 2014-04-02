package net.covoiturage.covoso.service;

import java.util.List;

import net.covoiturage.covoso.dao.CompteDao;
import net.covoiturage.covoso.form.Compte;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompteServiceImpl implements CompteService {

	@Autowired
	protected CompteDao udao;

	@Transactional
	public List<Compte> all() {
		return (udao).list();
	}

	@Transactional
	public void delete(Compte entity) {
		udao.delete(entity);
	}

	@Transactional
	public void remove(String login) {
		udao.remove(login);
	}

	@Transactional
	public void create(Compte entity) {
		udao.add(entity);

	}

	@Transactional
	public Compte single(String login) {
		return udao.single(login);
	}

	@Transactional
	public void update(Compte entity) {
		udao.update(entity);
	}
	@Transactional
	public int count() {
		return udao.count();
	}
	@Transactional
	public List<Compte> all(int page, int pagesize) {
		return udao.list(page, pagesize);
	}
	@Transactional
	public Compte login(String login, String pass) {
		Criterion l = Restrictions.eq("login", login);
		Criterion p = Restrictions.eq("password", pass);
		LogicalExpression le = Restrictions.and(l, p);
		List<Compte> ls = udao.find(le);
		if (ls.size() > 0)
			return ls.get(0);
		else
			return null;
	}
	@Transactional
	public Compte FindByLogin(String login) {
		Criterion l = Restrictions.eq("login", login);
		Criterion p = Restrictions.gt("utilisateurID", 0);
		LogicalExpression le = Restrictions.and(l, p);
		List<Compte> ls = udao.find(le);
		if (ls.size() > 0)
			return ls.get(0);
		else
			return null;
	}

}
