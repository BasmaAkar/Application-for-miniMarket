package org.lsi.market.web;

import java.util.List;


import org.lsi.market.dao.ArticleRepository;
import org.lsi.market.dao.LigneLivRepository;
import org.lsi.market.dao.LivraisonRepository;
import org.lsi.market.entities.Article;
import org.lsi.market.entities.Client;
import org.lsi.market.entities.LigneLiv;
import org.lsi.market.entities.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LigneLivController {
	@Autowired
	private LivraisonRepository livraisonRepository;
	@Autowired
	private LigneLivRepository ligneLivRepository;
	@Autowired
	private ArticleRepository articlerepository;
	
	public LigneLivController(LigneLivRepository ligneLivRepository) {
		super();
		this.ligneLivRepository =ligneLivRepository;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/ligneLivs")
	public String listLigneLivs(Model model) {
		model.addAttribute("ligneLivs", ligneLivRepository.findAll());
		return "ligneLivs";
	}
	
	@GetMapping("/ligneLivs/new")
	public String createLigneLivForm(Model model) {
		
		// create student object to hold student form data
		LigneLiv ligneLiv = new LigneLiv();
		model.addAttribute("ligneLiv", ligneLiv);
		 List<Livraison> Livraisons= livraisonRepository.findAll(); 
			model.addAttribute("livraisons", Livraisons);
			 List<Article> articles= articlerepository.findAll(); 

			model.addAttribute("articles", articles);

		return "create_ligneLiv";
		
	}
	
	@PostMapping("/ligneLivs")
	public String saveLigneLiv(@ModelAttribute("ligneLiv") LigneLiv ligneLiv) {
		ligneLivRepository.save(ligneLiv);
		Long id =ligneLiv.getArticle().getCodeArt();
		Article article= articlerepository.findById(id).get();
		article.setQteStock(ligneLiv.getQte_liv());

		articlerepository.save(article);
		return "redirect:/ligneLivs";
	}
	
	@GetMapping("/ligneLivs/edit/{id}")
	public String editLigneCmdForm(@PathVariable Long id, Model model) {
		model.addAttribute("ligneLiv", ligneLivRepository.findById(id).get());
		 List<Livraison> Livraisons= livraisonRepository.findAll(); 
			model.addAttribute("livraisons", Livraisons);
			 List<Article> articles= articlerepository.findAll(); 

			model.addAttribute("articles", articles);
		return "create_ligneLiv";
	}

	/*@PostMapping("/ligneLivs/{id}")
	public String updateLigneLiv(@PathVariable Integer id,@ModelAttribute("ligneLiv") LigneLiv ligneLiv, Model model) {
		
		// get student from database by id
		LigneLiv existingLigneLiv = ligneLivRepository.findById(id).get();
		existingLigneLiv.setNum_ligneliv(id);
		existingLigneLiv.setQte_liv(ligneLiv.getQte_liv());
		existingLigneLiv.setLivraison(ligneLiv.getLivraison());
		existingLigneLiv.setArticle(ligneLiv.getArticle());
		
		
		// save updated student object
		ligneLivRepository.save(existingLigneLiv);
		return "redirect:/ligneLivs";		
	}
	*/
	// handler method to handle delete student request
	
	@GetMapping("/ligneLivs/{id}")
	public String deleteLigneLiv(@PathVariable Long id) {
		
		ligneLivRepository.deleteById(id);
		return "redirect:/ligneLivs";
	}
	
	
}
