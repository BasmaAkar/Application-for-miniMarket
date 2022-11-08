package org.lsi.market.web;


import java.util.List;

import org.lsi.market.dao.FournisseurRepository;
import org.lsi.market.dao.SocieteRepository;
import org.lsi.market.entities.Fournisseur;
import org.lsi.market.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class SocieteController {
	@Autowired
	private SocieteRepository societeRepository;


	@Autowired
	private FournisseurRepository fournisseurRepository;
	// handler method to handle list students and return mode and view
	@GetMapping("/societes")
	public String listSocietes(Model model) {
		model.addAttribute("societes", societeRepository.findAll());
		return "societes";
	}
	
	@GetMapping("/societes/new")
	public String createSocieteForm(Model model) {
		
		// create student object to hold student form data
		Societe societe = new Societe();
		model.addAttribute("societe", societe);
		 List<Fournisseur> fournisseurs= fournisseurRepository.findAll(); 
			model.addAttribute("fournisseurs", fournisseurs);
		return "create_societe";
		
	}
	
	@PostMapping("/societes")
	public String saveSociete(@ModelAttribute("societe") Societe societe) {
		societeRepository.save(societe);
		return "redirect:/societes";
	}
	
	/*@GetMapping("/societes/edit/{id}")
	public String editLigneCmdForm(@PathVariable Integer id, Model model) {
		model.addAttribute("societe", societeRepository.findById(id).get());
		return "edit_societe";
	}*/
	@GetMapping("/societes/edit/{id}")
	public String editLivraisonForm(@PathVariable (value ="id") long id, Model model) {
		
		// get employee from the service
		Societe  societe  = societeRepository.findById(id).get();
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("societe", societe);
		model.addAttribute("pageTitle", "Edit Commande");
		 List<Fournisseur> fournisseurs= fournisseurRepository.findAll(); 
			model.addAttribute("fournisseurs", fournisseurs);
		return "create_societe";
	}

/*	@PostMapping("/societes/{id}")
	public String updateSociete(@PathVariable Integer id,
			@ModelAttribute("societe") Societe societe,
			Model model) {
		
		// get student from database by id
		Societe existingSociete = societeRepository.findById(id).get();
		existingSociete.setCod_ste(id);
		existingSociete.setNom_ste(societe.getNom_ste());
		existingSociete.setTel_ste(societe.getTel_ste());
		existingSociete.setFax_ste(societe.getFax_ste());
		existingSociete.setVille_ste(societe.getVille_ste());
		existingSociete.setFournisseur(societe.getFournisseur());
		
		
		// save updated student object
		societeRepository.save(existingSociete);
		return "redirect:/societes";		
	}*/
	
	// handler method to handle delete student request
	
	@GetMapping("/societes/{id}")
	public String deleteLigneCmd(@PathVariable Long id) {
		societeRepository.deleteById(id);
		return "redirect:/societes";
	}
	
}

