package net.covoiturage.covoso.dao;


import net.covoiturage.covoso.form.Utilisateur;

import org.springframework.stereotype.Repository;

@Repository("UtilisateurDao")
public class UtilisateurDaoImpl extends GenericDaoImpl<Utilisateur, Integer>
		implements UtilisateurDao {

}
