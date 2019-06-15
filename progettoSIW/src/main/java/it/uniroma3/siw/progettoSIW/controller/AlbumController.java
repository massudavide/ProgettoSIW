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
	
	@Autowired
	private FotografoService fotografoService;

	
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("albumForm") AlbumForm albumForm, //Da controllare
			Model model, BindingResult bindingResult) {
		
		this.albumValidator.validate(albumForm, bindingResult);
		if(!bindingResult.hasErrors()) {
			Album album=new Album();
			album.setTitolo(albumForm.getTitolo());
			album.setFotografo(fotografoService.fotografoPerId(Long.parseLong(albumForm.getFotografoId())));
			this.albumService.inserisci(album);
			model.addAttribute("album", this.albumService.tutti());
			return "album.html"; 
		}else {
			model.addAttribute("fotografi", this.fotografoService.tutti());
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
	public String addAlbum(Model model) {
		model.addAttribute("albumForm", new AlbumForm());
		model.addAttribute("fotografi", this.fotografoService.tutti());
		return "albumForm.html";
	}

}

