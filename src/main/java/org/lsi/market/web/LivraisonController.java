package org.lsi.market.web;



import java.util.List;

import org.lsi.market.dao.ClientRepository;
import org.lsi.market.dao.FournisseurRepository;
import org.lsi.market.dao.LivraisonRepository;
import org.lsi.market.entities.Client;
import org.lsi.market.entities.Commande;
import org.lsi.market.entities.Fournisseur;
import org.lsi.market.entities.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LivraisonController {
	@Autowired
	private LivraisonRepository livraisonRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;


	public LivraisonController(LivraisonRepository livraisonRepository) {
		super();
		this.livraisonRepository =livraisonRepository;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/livraisons")
	public String listLivraisons(Model model) {
		model.addAttribute("livraisons", livraisonRepository.findAll());
		return "livraisons";
	}
	
	@GetMapping("/livraisons/new")
	public String createLivraisonForm(Model model) {
		
		// create student object to hold student form data
		Livraison livraison = new Livraison();
		model.addAttribute("livraison", livraison);
		 List<Fournisseur> fournisseurs= fournisseurRepository.findAll(); 
			model.addAttribute("fournisseurs", fournisseurs);
		return "create_livraison";
		
	}
	
	@PostMapping("/livraisons/save")
	public String saveLivraison(@ModelAttribute("livraison") Livraison livraison) {
		livraisonRepository.save(livraison);
		return "redirect:/livraisons";
	}
	
	/*@GetMapping("/livraisons/edit/{id}")
	public String editLivraisonForm(@PathVariable Integer id, Model model) {
		model.addAttribute("livraison", livraisonRepository.findById(id).get() );
		return "edit_livraison";
	}*/
	
	@GetMapping("/livraisons/edit/{id}")
	public String editLivraisonForm(@PathVariable (value ="id") long id, Model model) {
		
		// get employee from the service
		Livraison  livraison  = livraisonRepository.findById(id).get();
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("livraison", livraison);
		model.addAttribute("pageTitle", "Edit Commande");
		 List<Fournisseur> fournisseurs= fournisseurRepository.findAll(); 
			model.addAttribute("fournisseurs", fournisseurs);
		return "create_livraison";
	}
	

	/*@PostMapping("/livraisons/{id}")
	public String updateLivraison(@PathVariable Integer id,
			@ModelAttribute("livraison") Livraison livraison,
			Model model) {
		
		// get student from database by id
		Livraison existingLivraison = livraisonRepository.findById(id).get();
		existingLivraison.setNum_liv(id);
		existingLivraison.setDate_liv(livraison.getDate_liv());
		existingLivraison.setFournisseur(livraison.getFournisseur());
		
		
		
		// save updated student object
		livraisonRepository.save(existingLivraison);
		return "redirect:/livraisons";		
	}*/
	
	// handler method to handle delete student request
	
	@GetMapping("/livraisons/{id}")
	public String deleteLivraison(@PathVariable Long id) {
		livraisonRepository.deleteById(id);
		return "redirect:/livraisons";
	}
	

}
