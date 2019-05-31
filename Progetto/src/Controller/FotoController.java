package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Foto;


@WebServlet("/fotoController") 
public class FotoController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// gestione della RICHIESTA
		// quando premo "invia", viene preparato un messaggio http che viene inviato al Server 
		
		String nextPage;

		HelperFoto helper= new HelperFoto();

		//Gestione della Sessione
		HttpSession session=request.getSession();

		Foto foto= new Foto();

		if(helper.isValid(request)) {
			nextPage="/risposta.jsp";
			foto.setTitolo(request.getParameter("titolo"));
			foto.setUrl(request.getParameter("file"));
			session.setAttribute("foto", foto);

		}

		else { 
			nextPage="/newFoto.jsp";
		}


		// inoltro
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}





}

	

