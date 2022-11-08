package org.lsi.market.web;

import java.util.List;

import org.lsi.market.dao.ArticleRepository;
import org.lsi.market.dao.ClientRepository;
import org.lsi.market.entities.Article;
import org.lsi.market.entities.Client;

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

public class ArticleController {
	
	@Autowired
	private ArticleRepository articlerepository  ;

	

	
	
	

	@GetMapping("/showNewarticleForm")
	public String showNewarticleForm(Model model) {
		// create model attribute to bind form data
		Article article = new Article();
		model.addAttribute("article",article );
		model.addAttribute("pageTitle", "Add new Article");

		return "form_article";
	}
	
	@PostMapping(path="/article/save") 
	private String saveArticle(@ModelAttribute("article") Article c) { 
		articlerepository.save(c);
      return "redirect:/Articles";
	 }
	

	
	@GetMapping(path="/Articles") 
	private String Articles(Model model) { 
	 List<Article> Articles= articlerepository.findAll(); 
	 model.addAttribute("listArticles", Articles); 
	 return "Articles"; 
	}
	
	
	@GetMapping("/Article/edit/{id}")
	public String showFormForUpdate(@PathVariable (value ="id") Long id, Model model) {
		
		// get employee from the service
		Article article = articlerepository.findById(id).get();
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("article", article);
		model.addAttribute("pageTitle", "Edit Article");

		return "form_article";
	}
	
	
	@GetMapping(path="/deleteArticle/{id}") 
	private String deletearticle(@PathVariable(name="id") Long id) { 
		articlerepository.deleteById(id);
		return "redirect:/Articles";

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
