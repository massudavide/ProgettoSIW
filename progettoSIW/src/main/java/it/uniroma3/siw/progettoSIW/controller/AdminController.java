package it.uniroma3.siw.progettoSIW.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progettoSIW.model.Admin;
import it.uniroma3.siw.progettoSIW.model.Album;
import it.uniroma3.siw.progettoSIW.services.AdminService;
import it.uniroma3.siw.progettoSIW.services.AdminValidator;
import it.uniroma3.siw.progettoSIW.services.AlbumForm;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminValidator adminValidator;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("admin") Admin admin, 
			Model model, BindingResult bindingResult) {
		this.adminValidator.validate(admin, bindingResult);
		if(!bindingResult.hasErrors()) {
			List<Admin> admins= adminService.tutti();
			for (Admin a:admins)
				if (a.getUsername().equals(admin.getUsername()))  
					if (a.getPsw().equals(admin.getPsw()))
						session.setAttribute("admin", a);
						
			
		if (session.getAttribute("admin")!=null)
			return "indexAdmin.html";
		else {
			model.addAttribute("frase", "Attenzione! Username o password errata.");
			return "adminForm.html";
	}
		}	
		return "adminForm.html";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		Admin a= new Admin("ciao", "ciao");
		adminService.inserisci(a);
		return "adminForm.html";
	}
	
	
	@RequestMapping("/utente")
	public String utente() {
		session.invalidate();
		return "index.html";
	}
}




