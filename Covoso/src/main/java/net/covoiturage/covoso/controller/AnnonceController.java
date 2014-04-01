package net.covoiturage.covoso.controller;

import java.util.Date;

import net.covoiturage.covoso.Utils.AnnonceValidator;
import net.covoiturage.covoso.Utils.MenuBuild;
import net.covoiturage.covoso.Utils.PagedGenericView;
import net.covoiturage.covoso.form.Annonce;
import net.covoiturage.covoso.service.AnnonceService;
import net.covoiturage.covoso.service.VoitureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/annonce")
public class AnnonceController {
	@Autowired
	private AnnonceService annonceService;
	@Autowired
	private VoitureService voitureService;

	@RequestMapping("/index")
	public ModelAndView Index() {
		return this.mvIndex(null, new Annonce(), "Ajoute d'Annonce",
				"/Covoso/annonce/add");
	}

	@RequestMapping("/index/{index}")
	public ModelAndView Index(@PathVariable("index") Integer index) {
		ModelAndView mv = new ModelAndView("annonce/index");
		mv.addObject("annonce", new Annonce());
		mv.addObject("message", null);
		mv.addObject("title", "Ajoute d'Annonce");
		mv.addObject("action", "/Covoso/annonce/add");
		PagedGenericView<Annonce> ulist = new PagedGenericView<Annonce>();

		ulist.getNav().setRowCount(annonceService.countAnnonce());

		if (index == null || index < 1)
			ulist.getNav().setCurrentPage(1);
		else
			ulist.getNav().setCurrentPage(index);

		ulist.setEntities(annonceService.allAnnonce(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView Add(@ModelAttribute("annonce") Annonce annonce,
			BindingResult result) {
		AnnonceValidator annonceValidator = new AnnonceValidator();
		annonceValidator.validate(annonce, result);
		String message = "";
		Annonce re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Annonce();
		} else {
			annonce.setDateCreate(new Date());
			annonceService.createAnnonce(annonce);
			message = "L'insertion réussi";
			re = annonce;
		}
		return this.mvIndex(message, re, "Ajoute d'Annonce",
				"/Covoso/annonce/add");
	}

	@RequestMapping("/edit/{annonceId}")
	public ModelAndView edit(
			@PathVariable("annonceId") Long annonceId) {
		return this.mvIndex(null, annonceService.singleAnnonce(annonceId),
				"Mis à jour d'Annonce", "/Covoso/annonce/edit/"
						+ annonceId);
	}

	@RequestMapping(value = "/edit/{annonceId}", method = RequestMethod.POST)
	public ModelAndView editPage(
			@PathVariable("annonceId") Long annonceId,
			@ModelAttribute("annonce") Annonce annonce,
			BindingResult result) {
		AnnonceValidator annonceValidator = new AnnonceValidator();
		annonceValidator.validate(annonce, result);
		String message = "";
		Annonce re;
		if (result.hasErrors()) {
			message = "Les données incorrectes";
			re = new Annonce();
		} else {
			Annonce nu = annonceService.singleAnnonce(annonceId);
			nu.setVilleArrivee(annonce.getVilleArrivee());
			nu.setEndroitArrivee(annonce.getEndroitArrivee());
			nu.setVilleDepart(annonce.getVilleDepart());
			nu.setEndroitDepart(annonce.getEndroitDepart());
			nu.setTitre(annonce.getTitre());
			nu.setDescription(annonce.getDescription());
			nu.setAutresEndroitsPasses(annonce.getAutresEndroitsPasses());
			nu.setDateDepart(annonce.getDateDepart());
			nu.setHeureDepart(annonce.getHeureDepart());
			nu.setNombrePlace(annonce.getNombrePlace());
			nu.setPrix(annonce.getPrix());
			nu.setTotalTemp(annonce.getTotalTemp());
			nu.setVoitureID(annonce.getVoitureID());
			annonceService.updateAnnonce(nu);
			message = "Le mis a jour réussi";
			re = annonce;
		}
		return this.mvIndex(message, new Annonce(), "Ajoute d'Annonce",
				"/Covoso/annonce/add");
	}
	@RequestMapping("/delete/{annonceId}")
	public ModelAndView delete(
			@PathVariable("annonceId") Long annonceId) {

		annonceService.removeAnnonce(annonceId);
		return this.mvIndex("La supression reussi", new Annonce(),
				"Ajoute d'Annonce", "/Covoso/annonce/add");
	}

	// la procedure commun
	public ModelAndView mvIndex(String message,
 Annonce annonce, String title,
			String action) {
		ModelAndView mv = new ModelAndView("annonce/index");
		mv.addObject("annonce", annonce);
		mv.addObject("message", message);
		mv.addObject("title", title);
		mv.addObject("action", action);
		mv.addObject("listVille", annonceService.allVille());
		mv.addObject("listVoiture", voitureService.all());
		PagedGenericView<Annonce> ulist = new PagedGenericView<Annonce>();
		ulist.getNav().setRowCount(annonceService.countAnnonce());

		ulist.getNav().setCurrentPage(1);
		ulist.setEntities(annonceService.allAnnonce(ulist.getNav()
				.getCurrentPage(), ulist.getNav().getPageSize()));

		mv.addObject("uList", ulist);
		mv.addObject("admenu", MenuBuild.AdminLogin("Annonce"));
		return mv;
	}
	@RequestMapping("/inscription/{annonceID}")
	public ModelAndView inscription(@PathVariable("annonceID") Long annonceID) {
		ModelAndView mv = new ModelAndView("annonce/inscription");
		mv.addObject("iList", annonceService.findbyAnnonce(annonceID));
		return mv;
	}
	@RequestMapping("/inscriptiondelete/{insid}")
	public ModelAndView inscriptionDelete(
			@PathVariable("insid") Long insid) {
		Long annonceID= annonceService.singleInscription(insid).getAnnonceID();
		annonceService.removeInscription(insid);
		ModelAndView mv = new ModelAndView("annonce/inscription/");
		mv.addObject("iList", annonceService.findbyAnnonce(annonceID));
		return mv;
	}
}
