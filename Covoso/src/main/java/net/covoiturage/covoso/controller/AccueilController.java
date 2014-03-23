package net.covoiturage.covoso.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;

import net.covoiturage.covoso.Utils.AnnonceValidator;
import net.covoiturage.covoso.Utils.CovosoUtils;
import net.covoiturage.covoso.Utils.LoginValidator;
import net.covoiturage.covoso.Utils.MenuBuild;
import net.covoiturage.covoso.Utils.PagedGenericView;
import net.covoiturage.covoso.Utils.UtilisateuretCompteValidator;
import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.form.Compte;
import net.covoiturage.covoso.form.Utilisateur;
import net.covoiturage.covoso.form.UtilisateuretCompte;

import net.covoiturage.covoso.service.AnnonceService;
import net.covoiturage.covoso.service.CompteService;
import net.covoiturage.covoso.service.UtilisateurService;
import net.covoiturage.covoso.service.VoitureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({ "utilisateur", "compte", "isAdmin" })
public class AccueilController {

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private CompteService compteService;
	@Autowired
	private VoitureService voitureService;

	@Autowired
	private AnnonceService annonceService;

	@RequestMapping("/")
	public ModelAndView accueil(ModelMap map) {
		ModelAndView mv = new ModelAndView("accueil");
		mv.addObject("recherchebox", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();
		alist.getNav().setRowCount(annonceService.countAnnonce());

		alist.getNav().setCurrentPage(1);
		alist.setEntities(annonceService.allAnnonce(alist.getNav()
				.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject(
				"menu",
				map.get("utilisateur") == null ? MenuBuild
						.AvantLogin("accueil") : MenuBuild
						.ApresLogin("accueil"));
		return mv;
	}
	@RequestMapping("/accueil/{index}")
	public ModelAndView accueil(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("annonce");
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();

		alist.getNav().setRowCount(annonceService.countAnnonce());

		if (index == null || index < 1)
			alist.getNav().setCurrentPage(1);
		else
			alist.getNav().setCurrentPage(index);

		alist.setEntities(annonceService.allAnnonce(alist.getNav()
				.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		return mv;
	}
	// 4. Recherche des covoiturages
	@RequestMapping("/recherche")
	public ModelAndView recherche(ModelMap map) {
		ModelAndView mv = new ModelAndView("recherche");
		mv.addObject("recherchebox", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject(
				"menu",
				map.get("utilisateur") == null ? MenuBuild
						.AvantLogin("recherche") : MenuBuild
						.ApresLogin("recherche"));
		return mv;
	}
	@RequestMapping(value="/recherche", method = RequestMethod.POST)
	public ModelAndView recherche(@ModelAttribute("recherche") Annonce rc,
			BindingResult result, ModelMap map) {
		ModelAndView mv = new ModelAndView("recherche");
		
		//recherche 
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();
		alist.getNav().setRowCount(annonceService.countAnnonceFind(rc));

		alist.getNav().setCurrentPage(1);
		alist.setEntities(annonceService.listAnnonceFind(rc,alist.getNav()
				.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject("display","true");
		mv.addObject("recherchebox", rc);
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject(
				"menu",
				map.get("utilisateur") == null ? MenuBuild
						.AvantLogin("recherche") : MenuBuild
						.ApresLogin("recherche"));
		return mv;
	}

	// 3. Inscription le nouveau utilisateur
	@RequestMapping("/inscription")
	public ModelAndView inscriptionPage() {
		ModelAndView mv = new ModelAndView("inscription");
		mv.addObject("menu", MenuBuild.AvantLogin("inscription"));
		UtilisateuretCompte uc = new UtilisateuretCompte();
		uc.setUtilisateur(new Utilisateur());
		uc.setCompte(new Compte());
		mv.addObject("uc", uc);
		return mv;
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ModelAndView inscription(
			@ModelAttribute("uc") UtilisateuretCompte uc, BindingResult result,
			ModelMap map) {
		ModelAndView mv = new ModelAndView("inscription");
		UtilisateuretCompteValidator ucValid = new UtilisateuretCompteValidator();
		ucValid.validate(uc, result);
		if (result.hasErrors()) {
			mv.addObject("message", "Certains champs manquent des informations");
		} else {
			utilisateurService.addUtilisateuretCompte(uc);
			mv.addObject("message", "Inscription reussi");
		}
		mv.addObject("menu", MenuBuild.AvantLogin("inscription"));
		return mv;
	}

	// 5. Ajoute des nouveaux annonces
	@RequestMapping("/ajouteannonce")
	public ModelAndView ajouteannoncePage(ModelMap map) {
		if (map.get("utilisateur") != null) {
			ModelAndView mv = new ModelAndView("ajouteannonce");
			mv.addObject("recherchebox", new Annonce());
			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("menu", MenuBuild.AvantLogin("accueil"));
			mv.addObject("an", new Annonce());
			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("listVoiture", voitureService.all());
			return mv;
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(value = "/ajouteannonce", method = RequestMethod.POST)
	public ModelAndView ajouteannonce(@ModelAttribute("an") Annonce an,
			BindingResult result, ModelMap map) {
		ModelAndView mv = new ModelAndView("ajouteannonce");
		AnnonceValidator ucValid = new AnnonceValidator();
		ucValid.validate(an, result);
		if (result.hasErrors()) {
			mv.addObject("message", "Certains champs manquent des informations");
		} else {
			an.setDateCreate(new Date());
			Utilisateur uti = (Utilisateur) map.get("utilisateur");
			an.setUtilisateurID(uti.getUtilisateurID());
			annonceService.createAnnonce(an);
			mv.addObject("message", "Inscription reussi");
		}
		mv.addObject("recherchebox", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject("menu", MenuBuild.AvantLogin("accueil"));
		mv.addObject("an", new Annonce());
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject("listVoiture", voitureService.all());
		mv.addObject("listHeure", CovosoUtils.HeureDepartDefault());
		
		
		return mv;
	}

	// 6. Liste des annonces nouveaux
	@RequestMapping("/vosannonces")
	public ModelAndView annoncelist(ModelMap map) {
		ModelAndView mv = new ModelAndView("vosannonces");
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();
		alist.getNav().setRowCount(annonceService.countAnnonceFindbyUtilisateur((Utilisateur) map.get("utilisateur")));

		alist.getNav().setCurrentPage(1);
		alist.setEntities(annonceService.listAnnonceFindbyUtilisateur((Utilisateur) map.get("utilisateur"),alist.getNav()
				.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject("menu", MenuBuild.ApresLogin("vos annonces"));
		return mv;
	}

	@RequestMapping("/vosannonces/{index}")
	public ModelAndView annoncelist(@PathVariable("index") Integer index,ModelMap map) {
		ModelAndView mv = new ModelAndView("vosannonces");
		PagedGenericView<Annonce> alist = new PagedGenericView<Annonce>();

		alist.getNav().setRowCount(annonceService.countAnnonceFindbyUtilisateur((Utilisateur) map.get("utilisateur")));

		if (index == null || index < 1)
			alist.getNav().setCurrentPage(1);
		else
			alist.getNav().setCurrentPage(index);

		alist.setEntities(annonceService.listAnnonceFindbyUtilisateur((Utilisateur) map.get("utilisateur"),alist.getNav()
				.getCurrentPage(), alist.getNav().getPageSize()));

		mv.addObject("aList", alist);
		mv.addObject("menu", MenuBuild.ApresLogin("vos annonces"));
		return mv;
	}
	// 7. Modifier compte
	@RequestMapping("/votrecompte")
	public ModelAndView votrecompte(ModelMap map) {
		if(map.get("utilisateur")!=null){
		ModelAndView mv = new ModelAndView("votrecompte");
		UtilisateuretCompte uc = new UtilisateuretCompte();
		uc.setCompte((Compte)map.get("compte"));
		uc.setUtilisateur((Utilisateur)map.get("utilisateur"));
		mv.addObject("uc", uc);
		mv.addObject("listVoiture", voitureService.find(((Utilisateur)map.get("utilisateur")).getUtilisateurID()));
		mv.addObject("menu",MenuBuild.ApresLogin("votre compte"));
		return mv;
		}
		else
			return new ModelAndView("redirect:/");
	}
	// 1. Login
	@RequestMapping("/login")
	public ModelAndView login(ModelMap map) {
		if (map.get("utilisateur") == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("compte", new Compte());
			mv.addObject("menu", MenuBuild.AvantLogin("s'identifier"));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("accueil");
			mv.addObject("recherchebox", new Annonce());
			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("menu", MenuBuild.ApresLogin("accueil"));
			return mv;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("compte") Compte compte,
			BindingResult result, ModelMap map) {
		LoginValidator valid = new LoginValidator();
		valid.validate(compte, result);
		String message = "";
		Compte newcompte = new Compte();
		;
		ModelAndView mv = new ModelAndView("login");
		if (result.hasErrors()) {
			message = "Les donnees incorrectes";
			mv.addObject("compte", new Compte());
			mv.addObject("message", message);
			mv.addObject("menu", MenuBuild.AvantLogin("s'identifier"));
			return mv;
		} else {
			newcompte = compteService.login(compte.getLogin(),
					compte.getPassword());
			if (newcompte != null) {
				map.addAttribute("utilisateur",
						utilisateurService.single(newcompte.getUtilisateurid()));
				map.addAttribute("compte", newcompte);
				// map.addAttribute("isAdmin").clear();
				return new ModelAndView("redirect:/");
			} else {
				message = "Compte n'existe pas";
				mv.addObject("compte", new Compte());
				mv.addObject("message", message);
				mv.addObject("menu", MenuBuild.AvantLogin("s'identifier"));
				return mv;
			}
		}
	}

	// 2.Logout
	@RequestMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		map.remove("utilisateur");
		map.remove("compte");
		map.remove("isAdmin");
		session.removeAttribute("utilisateur");
		session.removeAttribute("compte");
		session.removeAttribute("isAdmin");
		return "redirect:/";
	}

	// Page d'introduction de notre groupe
	@RequestMapping("/about")
	public ModelAndView about(ModelMap map) {
		
		if (map.get("utilisateur") == null) {
			ModelAndView mv = new ModelAndView("about");
			mv.addObject("recherchebox", new Annonce());
			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("menu", MenuBuild.AvantLogin("a propos nous"));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("about");
			mv.addObject("recherchebox", new Annonce());
			mv.addObject("listVille", annonceService.allVille());
			mv.addObject("menu", MenuBuild.ApresLogin("a propos nous"));
			return mv;
		}
	}

}
