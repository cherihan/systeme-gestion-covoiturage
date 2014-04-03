package net.covoiturage.covoso.dao;

import java.util.List;

import net.covoiturage.covoso.form.Inscription;

public interface InscriptionDao extends
 GenericDao<Inscription, Long> {
List<Inscription> findbyAnnonceId(Long annonceID);
}
