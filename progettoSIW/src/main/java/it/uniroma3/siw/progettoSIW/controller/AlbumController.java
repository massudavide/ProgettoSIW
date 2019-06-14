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
import it.uniroma3.siw.progettoSIW.model.*;
import it.uniroma3.siw.progettoSIW.services.*;


@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;

	@Autowired
	private AlbumValidator albumValidator;
	
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("album") Album album,
			Model model, BindingResult bindingResult) {
		
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.albumService.inserisci(album);
			model.addAttribute("album", this.albumService.tutti());
			return "album.html";
		}else {
			return "albumForm.html";
		}
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("album", this.albumService.albumPerId(id));
			return "album.html";
		}else {
			model.addAttribute("album", this.albumService.tutti());
			return "tuttiGliAlbum.html";
		}
	}
	
	@RequestMapping("/addAlbum")
	public String addFoto(Model model) {
		model.addAttribute("album", new Album());
		return "albumForm.html";
	}

}

