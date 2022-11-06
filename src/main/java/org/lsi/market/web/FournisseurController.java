package org.lsi.market.web;

import java.util.List;

import org.lsi.market.dao.FournisseurRepository;
import org.lsi.market.entities.Fournisseur;
import org.lsi.market.entities.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class FournisseurController {
	@Autowired
	private FournisseurRepository fournisseurRepository;


	
	// handler method to handle list students and return mode and view
	@GetMapping("/fournisseurs")
	public String listFournisseurs(Model model) {
		 List<Fournisseur> Fournisseurs = fournisseurRepository.findAll(); 
		model.addAttribute("fournisseurs",Fournisseurs); 
		return "fournisseurs";
	}
	
	@GetMapping("/fournisseurs/new")
	public String createFournisseurForm(Model model) {
		// create student object to hold student form data
		Fournisseur fournisseur = new Fournisseur();
		model.addAttribute("fournisseur", fournisseur);
		model.addAttribute("pageTitle", "Add new Fornisseur");

		return "create_fournisseur";
		
	}
	
	@PostMapping(path="/fournisseurs/save")
	public String saveFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur) {
		fournisseurRepository.save(fournisseur);
		return "redirect:/fournisseurs";
	}
	
	/*@GetMapping("/fournisseurs/edit/{id}")
	public String editFournisseurForm(@PathVariable Integer id, Model model) {
		model.addAttribute("fournisseur", fournisseurRepository.findById(id).get());
		return "edit_fournisseur";
	}*/
	@GetMapping("/fournisseurs/edit/{id}")
	public String editLivraisonForm(@PathVariable (value ="id") long id, Model model) {
		
		// get employee from the service
		Fournisseur  fournisseur  = fournisseurRepository.findById(id).get();
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("fournisseur", fournisseur);
		model.addAttribute("pageTitle", "Edit fournisseur");

		return "create_fournisseur";
	}
/*	@PostMapping("/fournisseurs/{id}")
	public String updateFournisseur(@PathVariable Integer id,
			@ModelAttribute("fournisseur") Fournisseur fournisseur,
			Model model) {
		
		// get student from database by id
		Fournisseur existingFournisseur = fournisseurRepository.findById(id).get();
		existingFournisseur.setCod_four(id);
		existingFournisseur.setNom_four(fournisseur.getNom_four());
		existingFournisseur.setVille_four(fournisseur.getVille_four());
		existingFournisseur.setTel_four(fournisseur.getTel_four());

		// save updated student object
		fournisseurRepository.save(existingFournisseur);
		return "redirect:/fournisseurs";		
	}*/
	
	
	// handler method to handle delete student request
	
	@GetMapping("/fournisseurs/{id}")
	public String deleteFournisseur(@PathVariable Long id) {
		fournisseurRepository.deleteById(id);
		return "redirect:/fournisseurs";
	}
	
}

