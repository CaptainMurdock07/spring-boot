package meslivres;

import java.util.ArrayList;

public class Livre {

	private int idLivre;
	private String titre;
	private String auteur;
	private String editeur;
	private double prix;
	private String url_image;

	public Livre(int idLivre, String titre, String auteur, String editeur, double prix, String url_image) {
		super();
		this.idLivre = idLivre;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.prix = prix;
		this.url_image = url_image;
	}
	public Livre(int id) {
		ArrayList<Livre> livres = getLivres();
		this.idLivre = livres.get(id-1).idLivre;
		this.titre = livres.get(id-1).titre;
		this.auteur = livres.get(id-1).auteur;
		this.editeur = livres.get(id-1).editeur;
		this.prix = livres.get(id-1).prix;
		this.url_image = livres.get(id-1).url_image;		
	}
	public static ArrayList<Livre> getLivres() {
		ArrayList<Livre> livres = new ArrayList<Livre>();
		livres.add(new Livre(1, "Le rouge et le noir", "Stendhal", "Flammarion", 8.0,
				"https://cdn.shopify.com/s/files/1/0517/5915/3314/products/0381233_600x600_crop_center.jpg?v=1656292458"));
		livres.add(new Livre(2, "Eugégie Grandet", "Honoré De Balzac", "Flammarion", 6.0,
				"https://cdn.shopify.com/s/files/1/0517/5915/3314/products/0208943-3_2fe506f8-afaa-4bb4-ba91-559eed360849_600x600_crop_center.jpg?v=1656291966"));
		livres.add(new Livre(3, "Germinal", "Emile Zola", "Flammarion", 11.0,
				"https://cdn.shopify.com/s/files/1/0517/5915/3314/products/0035681_600x600_crop_center.jpg?v=1656031362"));
		return livres;
	}


	public int getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

}
