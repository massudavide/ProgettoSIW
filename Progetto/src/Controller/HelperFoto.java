package Controller;


import javax.servlet.http.HttpServletRequest;

public class HelperFoto {
	public boolean isValid(HttpServletRequest request) {
		boolean corretto=true;
		String titolo = request.getParameter("titolo");
		String file = request.getParameter("file");
		
		if (titolo.equals("")) {
			request.setAttribute("errorTitolo", "Campo obbligatorio!");
			corretto=false;
		}

		if (file.equals("")) {
			request.setAttribute("errorFile", "Campo obbligatorio!");
			corretto=false;
		}
		
		return corretto;
	}
}
