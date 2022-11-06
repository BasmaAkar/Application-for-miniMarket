package org.lsi.market.web;

import java.util.List;

import org.lsi.market.dao.ArticleRepository;
import org.lsi.market.dao.ClientRepository;
import org.lsi.market.dao.CommandeRepository;
import org.lsi.market.dao.FournisseurRepository;
import org.lsi.market.dao.LigneLivRepository;
import org.lsi.market.dao.Ligne_cmdRepository;
import org.lsi.market.dao.LivraisonRepository;
import org.lsi.market.dao.SocieteRepository;
import org.lsi.market.entities.Article;
import org.lsi.market.entities.Client;
import org.lsi.market.entities.Commande;
import org.lsi.market.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ArticleRepository articlerepository  ;
	@Autowired
	private CommandeRepository commanderepository  ;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private SocieteRepository societeRepository;
	@Autowired
	private LigneLivRepository ligneLivRepository;
	@Autowired
	private LivraisonRepository livraisonRepository;

	@Autowired
	private Ligne_cmdRepository ligne_cmdrepository  ;
	@GetMapping("/home")
	public String home(Model model) {
		

		model.addAttribute("tailleclient", clientRepository.findAll().size());
		model.addAttribute("taillecommande", commanderepository.findAll().size());
		model.addAttribute("taillearticle", articlerepository.findAll().size());
		model.addAttribute("taillefournisseur", fournisseurRepository.findAll().size());
		model.addAttribute("taillelivraison", livraisonRepository.findAll().size());
		model.addAttribute("taillesociete",  societeRepository.findAll().size());
		model.addAttribute("taillelignel",  ligneLivRepository.findAll().size());
		model.addAttribute("taillelignec",  ligne_cmdrepository.findAll().size());

		return "home";
	}
}
