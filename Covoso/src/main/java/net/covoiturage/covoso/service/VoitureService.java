package net.covoiturage.covoso.service;

import java.util.List;

import net.covoiturage.covoso.form.Voiture;

public interface VoitureService {
	void create(Voiture entity);

	List<Voiture> all();

	void update(Voiture entity);

	Voiture single(Long id);

	void remove(Long id);

	void delete(Voiture u);

	int count();

	List<Voiture> all(int page, int pagesize);
	
	List<Voiture> find(Integer utiliseurID);
	
}
