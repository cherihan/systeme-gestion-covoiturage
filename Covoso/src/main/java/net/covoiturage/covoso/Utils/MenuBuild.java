package net.covoiturage.covoso.Utils;

import java.util.ArrayList;
import java.util.List;

public class MenuBuild {
	public static List<MenuItem> AvantLogin(String nameActive) {
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list.add(new MenuItem("/Covoso/", "Accueil", ""));
		list.add(new MenuItem("/Covoso/recherche", "Recherche", ""));
		list.add(new MenuItem("/Covoso/inscription", "Inscription", ""));
		list.add(new MenuItem("/Covoso/login", "S'identifier", ""));
		list.add(new MenuItem("/Covoso/about", "A propos nous", ""));
		for (MenuItem menuItem : list) {
			if (menuItem.name.toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.setIsCurrent("current");
		}
		return list;
	}

	public static List<MenuItem> ApresLogin(String nameActive) {
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list.add(new MenuItem("/Covoso/", "Accueil", ""));
		list.add(new MenuItem("/Covoso/recherche", "Recherche", ""));
		list.add(new MenuItem("/Covoso/vosannonces", "Vos Annonces", ""));
		list.add(new MenuItem("/Covoso/votrecompte", "Votre Compte", ""));
		list.add(new MenuItem("/Covoso/about", "A propos nous", ""));
		for (MenuItem menuItem : list) {
			if (menuItem.name.toLowerCase().compareTo(nameActive.toLowerCase()) == 0)
				menuItem.setIsCurrent("current");
		}
		return list;
	}
}
