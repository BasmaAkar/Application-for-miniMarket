package org.lsi.market.web;

import java.util.List;

import org.lsi.market.dao.ArticleRepository;
import org.lsi.market.dao.ClientRepository;
import org.lsi.market.dao.CommandeRepository;
import org.lsi.market.entities.Article;
import org.lsi.market.entities.Client;
import org.lsi.market.entities.Commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CommandeController {
	@Autowired
	private CommandeRepository commanderepository  ;
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/showNewCommandeForm")
	public String showNewCommandeForm(Model model) {
		// create model attribute to bind form data
		Commande commande = new Commande();
		model.addAttribute("commande",commande );
		model.addAttribute("pageTitle", "Add new Commande");
		 List<Client> Clients= clientRepository.findAll(); 
			model.addAttribute("clients", Clients);
		return "form_commande";
	}
	
	@PostMapping(path="/commande/save") 
	private String saveCommande(@ModelAttribute("commande") Commande c) { 
		commanderepository.save(c);
      return "redirect:/Commandes";
	 }
	

	
	@GetMapping(path="/Commandes") 
	private String Articles(Model model) { 
	 List<Commande> Commandes= commanderepository.findAll(); 
	 model.addAttribute("listCommandes", Commandes); 
	 return "Commandes"; 
	}
	
	
	@GetMapping("/Commande/edit/{id}")
	public String showFormForUpdate(@PathVariable (value ="id") Long id, Model model) {
		
		// get employee from the service
		Commande commande = commanderepository.findById(id).get();
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("commande", commande);
		model.addAttribute("pageTitle", "Edit Commande");
		 List<Client> Clients= clientRepository.findAll(); 
			model.addAttribute("clients", Clients);
		return "form_commande";
	}
	
	
	@GetMapping(path="/deleteCommande/{id}") 
	private String deleteCommande(@PathVariable(name="id") Long id) { 
		commanderepository.deleteById(id);
		return "redirect:/Commandes";

	 }
	
	/*
	@GetMapping(path="/edit/{id}") 
	private ModelAndView showeditclientpage(@PathVariable(name="codeCli") Long id ) { 
		ModelAndView editview =new ModelAndView("edit-client-form");
		Client client =clientRepository.findClientBycodeCli(id);
		editview.addObject("Client", client);
      return editview;
	 }*/
	
	
	
	/*@GetMapping(path="/updateclients/{id}") 
	private void update(Client c) { 
		clientRepository.save(c);
      return;
	 }*/ 
	
	 
}
