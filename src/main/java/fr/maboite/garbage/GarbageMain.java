package fr.maboite.garbage;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.tp.servlet.Article;

public class GarbageMain {
	

	
	public static void main(String args[]) {
		boolean isTrue = true;
		
		List<Article> articles = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			Article article = new Article();
			articles.add(article);
		}
		
		for(Article article : articles) {
			article = null;
		}
		
		
		
		//methodeQuiPrendDeLaMemoire();
	}
	
	
	private static void uneAutreMethode() {

		List<String> cibles = new ArrayList<>();
		cibles.add("fichier-1.txt");
		cibles.add("fichier-2.txt");
		cibles.add("fichier-super.txt");
		cibles.add("fichier-top.txt");

		byte[] monGrosTableau = litFichierDansUnTableau();
		for(String cible : cibles) {
			ecrireFichierVersCible(cible, monGrosTableau);
		}
		
	}

	private static void ecrireFichierVersCible(String cible, byte[] monGrosTableau) {
		// TODO Auto-generated method stub
		
	}


	private static byte[] litFichierDansUnTableau() {
		// TODO Auto-generated method stub
		return null;
	}


	private static void methodeQuiPrendDeLaMemoire() {
		// TODO Auto-generated method stub
		
	}

	private static void methodeCourte() {
		// TODO Auto-generated method stub
		
	}

}
