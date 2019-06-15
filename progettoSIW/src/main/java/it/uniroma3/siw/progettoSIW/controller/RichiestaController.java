package it.uniroma3.siw.progettoSIW.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progettoSIW.model.Foto;
import it.uniroma3.siw.progettoSIW.model.Richiesta;
import it.uniroma3.siw.progettoSIW.services.FotoService;
import it.uniroma3.siw.progettoSIW.services.RichiestaService;

@Controller
public class RichiestaController {

	@Autowired
	private RichiestaService richiestaService;
	
	@Autowired
	private FotoService fotoService;
	
	@Autowired
	private HttpSession session;
	
	//BHO
	@RequestMapping("/addFotos")
	public void addRichiesta(Model model) {
		model.addAttribute("richiesta", new Richiesta()); 
	}
	
	@RequestMapping("/mostraCarrello")
	public String mostraCarrello(Model model) {
		Richiesta richiesta= (Richiesta) session.getAttribute("richiesta");
		if (richiesta==null || richiesta.getListaFoto().size()==0)
			return "carrelloVuoto.html";
			else {
				model.addAttribute("fotografie",richiesta.getListaFoto());
				return "carrello.html";
			}	 
	}
	
	
	// AGGIUNGO FOTO AL CARRELLO
	@RequestMapping(value = "/addFotoRichiesta/{id}", method = RequestMethod.GET)
	public String addFotoRichiesta(@PathVariable("id") Long id, Model model) {
		if(id==null) {
			return "error404.html";
		}
		else {
			Richiesta r= null;
			Foto foto= fotoService.fotoPerId(id);
			if (session.getAttribute("richiesta")==null){
			r= new Richiesta();
			session.setAttribute("richiesta", r);
			r.setListaFoto(new ArrayList<Foto>());
			richiestaService.inserisci(r);
			}
			else {
				r=(Richiesta) session.getAttribute("richiesta");
			}
			
			r.getListaFoto().add(foto);
			richiestaService.inserisci(r);
			model.addAttribute("fotografie", r.getListaFoto());
			return "carrello.html";
		}
	}
	
	// ELIMINO FOTO DAL CARRELLO
	@RequestMapping(value = "/deleteFotoRichiesta/{id}", method = RequestMethod.GET)
	public String deleteFotoRichiesta(@PathVariable("id") Long id, Model model) {
		if(id==null) {
			return "error404.html";
		}
		else {
			Richiesta richiesta= (Richiesta) session.getAttribute("richiesta");
			List<Foto> lista= richiesta.getListaFoto();
			Foto fotoDaEliminare=null;
			for (Foto f:lista)
				if (f.getId().equals(id))
					fotoDaEliminare=f;
			lista.remove(fotoDaEliminare);
			richiestaService.inserisci(richiesta);
			model.addAttribute("fotografie", richiesta.getListaFoto());
			return "carrello.html";
		}
	}
	
	
	
	//ORA NON SERVE
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
