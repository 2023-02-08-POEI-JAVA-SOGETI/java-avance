package fr.maboite.correction.tp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ajout-panier", displayName = "La servlet d'ajout au panier", 
	urlPatterns = "/ajout-panier", loadOnStartup = 1)
public class AjoutPanierServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/** Création d'un nouvel attribut statique qui nous sert à logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(AjoutPanierServlet.class);

	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Appel de la méthode doGet.");

		// initialisation de la réponse
		response.setContentType("text/html");
		response.setBufferSize(4096);

		String idAsString = request.getParameter("id");
		Integer id = Integer.parseInt(idAsString);
		
		Panier panier = (Panier) request.getSession().getAttribute("panier");
		if(panier == null) {
			panier = new Panier();
		}
		panier.ajouteArticle(id);
		

		try (PrintWriter out = response.getWriter()) {
			out.println("L'élément avec l'id : " + id + " a été ajouté au panier.");
		}

		LOGGER.info("Fin de la méthode doGet.");
	}

}