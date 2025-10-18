public class CD extends Media {
    private String artiste;
    private int duree;  // en minutes

    public CD(String titre, int anneePublication, String artiste, int duree) {
        super(titre, anneePublication);
        this.artiste = artiste;
        this.duree = duree;
    }

    public String getArtiste() {
        return artiste;
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public String getDescription() {
        return "CD de " + artiste + ", durée : " + duree + " min.";
    }
}