package fr.maboite.correction.tp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Panier", displayName = "La servlet du panier", urlPatterns = "/panier", loadOnStartup = 1)
public class PanierServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/** Création d'un nouvel attribut statique qui nous sert à logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(PanierServlet.class);

	private ArticleDao articleDao = new ArticleDao();

	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Appel de la méthode doGet.");

		// initialisation de la réponse
		response.setContentType("text/html");
		response.setBufferSize(4096);

		// Récupération des articles avec le DAO (Data Access Object)
		List<Article> articles = articleDao.getAllArticles();

		//Récupération du panier
		Panier panier = (Panier) request.getSession().getAttribute("panier");
		if(panier == null) {
			panier = new Panier();
			request.getSession().setAttribute("panier", panier);
		}
		
		
		//Création de la liste des articles du panier
		// Récupération de out : il nous permettra d'écrire dans la réponse
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>"
					+ "<head><title>Page des articles dans le panier</title></head>");
			out.println("<body  bgcolor=\"#ffffff\">");

			// SI articles n'est pas vide, on crée un tableau HTML
			if (!panier.getIds().isEmpty()) {
				LOGGER.debug("Le panier n'est pas vide, un tableau doit être construit en HTML.");

				out.println("<p>Voici le contenu du panier: </p>");
				out.println("<table>");
				out.println("<tr><th>Id</th><th>Nom</th><th>Prix</th><th>Quantité</th></tr>");
				// Pour chaque article, on crée une ligne dans le tableau HTML
				for (Integer articleId : panier.getIds().keySet()) {
					
					Article article = getArticleById(articles, articleId);
					out.println("<tr>"
							+ "<td>"
							+ article.getId()
							+ "</td>"
							+ "<td>"
							+ article.getNom()
							+ "</td>"
							+ "<td>"
							+ article.getCategorie()
							+ "</td>"
							+ "<td>"
							+ panier.getIds().get(articleId)
							+ "</td>"
							+ "<td>"
							+ "<a href='./suppression-panier?id=" + article.getId() + " '>supprimer</a>"
							+ "</td>"
							+ "</tr>");
				}
				// Fermeture des balises
				out.println("</table>");

			} else {
				out.println("<p>Désolé, aucun article dans le panier</p>");
			}

			// Fermeture des balises
			out.println("</body></html>");
		}
		LOGGER.info("Fin de la méthode doGet.");
	}

	private Article getArticleById(List<Article> articles, Integer articleId) {
		for(Article article : articles) {
			if(article.getId().equals(articleId)) {
				return article;
			}
		}
		return null;
	}

}