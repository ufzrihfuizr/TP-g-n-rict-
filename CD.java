public class CD extends Media {
    //initialisation des variables utilisées
    private String artiste;
    private int duree;  // en minutes

    //constructeur paramétré
    public CD(String titre, int anneePublication, String artiste, int duree) {
        super(titre, anneePublication);
        this.artiste = artiste;
        this.duree = duree;
    }
//getter rendant possible l'acces à la variable privée artiste
    public String getArtiste() {
        return artiste;
    }
   //getter rendant possible l'acces à la variable privée durée
    public int getDuree() {
        return duree;
    }

    //modification(écrasement) de la valeur retournée de la methode getDescription initialement declaré dans la classe Media et hérité depuis la class CD
    @Override
    public String getDescription() {
        return "CD de " + artiste + ", durée : " + duree + " min.";
    }

}


