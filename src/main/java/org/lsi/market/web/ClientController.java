package org.lsi.market.web;

import java.util.List;

import org.lsi.market.dao.ClientRepository;
import org.lsi.market.entities.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model; 
@Controller
public class ClientController {
	 
	@Autowired
	private ClientRepository clientRepository;
	/*@RequestMapping(value="/clients",method=RequestMethod.POST) 
	public Client saveClient(@RequestBody Client c) { 
	 return clientMetier.saveClient(c); 
	 }  
	@RequestMapping(value="/clients",method=RequestMethod.GET) 
	public List<Client> listClient() { 
	 return clientMetier.listClient(); 
	 } 
	@RequestMapping(value="/clients",method=RequestMethod.GET) 
	public List<Client> DeleteClient() { 
	 return clientMetier.listClient(); 
	 } */
	
	/*@GetMapping(path="/saveClient-form") 
	private String showsaveform(Model model) { 
		Client client =new Client();
		model.addAttribute("client",client);
		model.addAttribute("pageTitle", "Add new client");
      return "save-client-form";
	 }*/
	
	
	

	@GetMapping("/showNewclientForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Client client = new Client();
		model.addAttribute("client",client );
		model.addAttribute("pageTitle", "Add new client");
		return "new_client";
	}
	
	@PostMapping(path="/client/save") 
	private String saveClient(@ModelAttribute("client") Client c) { 
		clientRepository.save(c);
      return "redirect:/Clients";
	 }
	

	
	@GetMapping(path="/Clients") 
	private String products(Model model) { 
	 List<Client> Clients= clientRepository.findAll(); 
	 model.addAttribute("listClients", Clients); 
	 return "Clients"; 
	}
	
	
	@GetMapping("/client/edit/{id}")
	public String showFormForUpdate(@PathVariable (value ="id") long id, Model model) {
		
		// get employee from the service
		Client client = clientRepository.findById(id).get();
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("client", client);
		model.addAttribute("pageTitle", "Edit client");
		return "new_client";
	}
	
	
	@GetMapping(path="/deleteClient/{id}") 
	private String deleteclient(@PathVariable(name="id") Long id) { 
		clientRepository.deleteById(id);
		return "redirect:/Clients";

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
