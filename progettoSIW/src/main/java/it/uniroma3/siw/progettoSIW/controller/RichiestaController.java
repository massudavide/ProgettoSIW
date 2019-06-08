package it.uniroma3.siw.progettoSIW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progettoSIW.model.Richiesta;
import it.uniroma3.siw.progettoSIW.services.RichiestaService;

@Controller
public class RichiestaController {

	@Autowired
	private RichiestaService richiestaService;
	

	@RequestMapping("/addRichiesta")
	public void addRichiesta(Model model) {
		model.addAttribute("richiesta", new Richiesta()); 
	}


	@RequestMapping(value = "/richiesta/{id}", method = RequestMethod.GET)
	public String getRichiesta(@PathVariable("id") Long id, Model model) {
		if(id==null) {
			return "error404.html";
		}
		else {
			model.addAttribute("richiesta", this.richiestaService.richiestaPerId(id));
			return "richiesta.html";
		}
	}
	
}
