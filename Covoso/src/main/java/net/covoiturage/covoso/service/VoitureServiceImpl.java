package net.covoiturage.covoso.service;

import java.util.List;

import net.covoiturage.covoso.dao.VoitureDao;
import net.covoiturage.covoso.form.Voiture;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	protected VoitureDao vdao;

	@Transactional
	public List<Voiture> all() {
		return (vdao).list();
	}

	@Transactional
	public void delete(Voiture voi) {
		vdao.delete(voi);
	}

	@Transactional
	public void remove(Long id) {
		vdao.remove(id);
	}

	@Transactional
	public void create(Voiture voi) {
		vdao.add(voi);

	}

	@Transactional
	public Voiture single(Long id) {
		return vdao.single(id);
	}

	@Transactional
	public void update(Voiture voi) {
		vdao.update(voi);
	}

	public int count() {
		return vdao.count();
	}

	public List<Voiture> all(int page, int pagesize) {
		return vdao.list(page, pagesize);
	}


	public List<Voiture> find(Integer utiliseurID) {
		Criterion con = Restrictions.eq("utilisateurID", utiliseurID);
		Criterion con2 = Restrictions.gt("utilisateurID", 0);
		LogicalExpression expression = Restrictions.and(con, con2);
		return vdao.find(expression);
	}
	public Voiture findbyID(Long voitureID ) {
		try{
		Criterion con = Restrictions.eq("voitureID", voitureID);
		Criterion con2 = Restrictions.gt("voitureID", 0);
		LogicalExpression expression = Restrictions.and(con, con2);
		return vdao.find(expression).get(0);
		}catch(Exception e){
			return null;
		}
	}

}
