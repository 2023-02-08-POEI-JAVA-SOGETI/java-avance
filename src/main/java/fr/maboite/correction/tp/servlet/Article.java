package fr.maboite.correction.tp.servlet;

public class Article {
	
	private Integer id = Integer.valueOf(4);

	private String nom;
	private String categorie = "défaut";
	
	public Article() {
	}

	public Article(Article other) {
		this.id = other.id;
		this.nom = other.nom;
		this.categorie = other.categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}
