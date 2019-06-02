package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Model.Admin;

public class AdminServices {
	private List<Admin> amministratori;
	
	public AdminServices() {
		this.amministratori= new ArrayList<>();
		Admin a1= new Admin("franco", "franco");
		Admin a2= new Admin("davide", "davide");

		amministratori.add(a1);
		amministratori.add(a2);
	}
	
	public boolean isValid(HttpServletRequest request) {
		boolean corretto=false;
		String username = request.getParameter("username");
		String psw = request.getParameter("password");
		
		for (Admin admin:amministratori) {
			if (username.equals(admin.getUsername()) )
				if (psw.equals(admin.getPsw()))
						corretto=true;
		}
		
		if (!corretto)
			request.setAttribute("errorLogin", "I dati inseriti non sono validi!");
		
		return corretto;
	}
	
}
