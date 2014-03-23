package net.covoiturage.covoso.service;

import java.util.List;

import net.covoiturage.covoso.form.Compte;

public interface CompteService {
	void create(Compte user);

	List<Compte> all();

	void update(Compte entity);

	Compte single(String login);

	void remove(String login);

	void delete(Compte entity);

	int count();

	List<Compte> all(int page, int pagesize);
	
	Compte login(String login, String pass);
}
