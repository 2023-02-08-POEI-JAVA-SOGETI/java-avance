package fr.maboite.correction.tp.servlet;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe utilitaire pour stocker des ids de Article et des quantités
 */
public class Panier {

	private static final Logger LOGGER = LoggerFactory.getLogger(Panier.class);
	
	private Map<Integer, Integer> ids = new HashMap<>();

	/**
	 * Si la map contient déjà un 
	 * article, la quantité est augmentée de 1. 
	 * Sinon, la quantité passe à 1.
	 * @param id
	 */
	public void ajouteArticle(Integer id) {
		Integer previousValue = 0;
		if(ids.containsKey(id)) {
			previousValue = ids.get(id);
		}
		LOGGER.info("Ajout dans le panier d'un article avec l'id : " + id + " , l'ancienne quantité valait : " + previousValue);
		previousValue++;
		ids.put(id, previousValue);		
	}

	/**
	 * Renvoie la Map des <Id,Quantité>
	 * @return
	 */
	public Map<Integer, Integer> getIds() {
		return ids;
	}

	/**
	 * Supprime l'article avec l'id de
	 * la map des ids
	 * @param id
	 */
	public void supprimeArticle(Integer id) {
		ids.remove(id);
	}
	
}
