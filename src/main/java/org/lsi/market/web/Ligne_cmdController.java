package org.lsi.market.web;

import java.util.List;

import org.lsi.market.dao.ArticleRepository;
import org.lsi.market.dao.CommandeRepository;
import org.lsi.market.dao.Ligne_cmdRepository;
import org.lsi.market.entities.Article;
import org.lsi.market.entities.Commande;
import org.lsi.market.entities.Ligne_cmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ligne_cmdController {

	@Autowired
	private Ligne_cmdRepository ligne_cmdrepository  ;
	@Autowired
	private ArticleRepository articlerepository  ;
	@Autowired
	private CommandeRepository commanderepository  ;

	@GetMapping("/showNewLigne_cmdsForm")
	public String showNewLigne_cmdForm(Model model) {
		// create model attribute to bind form data
		Ligne_cmd ligne_cmd = new Ligne_cmd();
		model.addAttribute("ligne_cmd",ligne_cmd );
		model.addAttribute("pageTitle", "Add new Ligne_cmd");
		 List<Article> articles= articlerepository.findAll(); 
		 List<Commande> Commandes= commanderepository.findAll(); 

			model.addAttribute("articles", articles);
			model.addAttribute("commandes",Commandes );


		return "form_Ligne_cmd";
	}
	
	@PostMapping(path="/ligne_cmd/save") 
	private String saveLigne_cmd(@ModelAttribute("ligne_cmd") Ligne_cmd c) { 
		ligne_cmdrepository.save(c);
      return "redirect:/Ligne_cmds";
	 }
	

	
	@GetMapping(path="/Ligne_cmds") 
	private String Articles(Model model) { 
	 List<Ligne_cmd> Ligne_cmd= ligne_cmdrepository.findAll(); 
	 model.addAttribute("listLigne_cmds", Ligne_cmd); 
	 return "Ligne_cmds"; 
	}
	
	
	@GetMapping("/Ligne_cmd/edit/{id}")
	public String showFormForUpdate(@PathVariable (value ="id") long id, Model model) {
		
		// get employee from the service
		Ligne_cmd ligne_cmd = ligne_cmdrepository.findByNumLigne(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("ligne_cmd", ligne_cmd);
		model.addAttribute("pageTitle", "Edit Ligne_cmd");
		 List<Article> articles= articlerepository.findAll(); 
		 List<Commande> Commandes= commanderepository.findAll(); 

			model.addAttribute("articles", articles);
			model.addAttribute("commandes",Commandes );
		return "form_ligne_cmd";
	}
	
	
	@GetMapping(path="/deleteLigne_cmd/{id}") 
	private String deleteCommande(@PathVariable(name="id") Long id) { 
	Ligne_cmd ligne_cmd = ligne_cmdrepository.findByNumLigne(id);
		ligne_cmdrepository.delete(ligne_cmd);
		return "redirect:/Ligne_cmds";
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
