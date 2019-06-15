package it.uniroma3.siw.progettoSIW.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progettoSIW.services.FotoService;
import it.uniroma3.siw.progettoSIW.model.Foto;
import it.uniroma3.siw.progettoSIW.services.FotoValidator;

@Controller
public class FotoController{
	
	@Autowired
	private FotoService fotoService;

	@Autowired
	private FotoValidator fotoValidator;
	
	@RequestMapping(value = "/foto", method = RequestMethod.POST)
	public String newFoto(@Valid @ModelAttribute("foto") Foto foto,
			Model model, BindingResult bindingResult) {
		
		this.fotoValidator.validate(foto, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotoService.inserisci(foto);
			model.addAttribute("foto", this.fotoService.tutti());
			return "foto.html";
		}else {
			return "fotoForm.html";
		}
	}
	
	@RequestMapping(value = "/foto/{id}", method = RequestMethod.GET)
	public String getFoto(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("foto", this.fotoService.fotoPerId(id));
			return "foto.html";
		}else {
			model.addAttribute("foto", this.fotoService.tutti());
			return "tutteLeFoto.html";
		}
	}
	
	@RequestMapping("/addFoto")
	public String addFoto(Model model) {
		model.addAttribute("foto", new Foto());
		return "fotoForm.html";
	}

}