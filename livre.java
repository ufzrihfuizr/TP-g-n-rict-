//heritage de l'ensemble des variables,methodes,propriétés... de la classe Media depuis la classe Livre
public class Livre extends Media {
    //initialisation des variables utilisées dans la classe
    private String auteur;
    private int nbPages;
//constructeur de la classe paramétré
    public Livre(String titre, int anneePublication, String auteur, int nbPages) {
        super(titre, anneePublication);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }
//getter pour acceder au nom de l'auteur
    public String getAuteur() {
        return auteur;
    }
//getter pour acceder au nombre de pages
    public int getNbPages() {
        return nbPages;
    }
//ecrasement de la valeur retournée depuis la classe mère de la methode getDescription
    @Override
    public String getDescription() {
        return "Livre de " + auteur + ", " + nbPages + " pages.";
    }

}
