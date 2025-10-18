public class Membre {
    //initialisation des variables utlisées dans la classe
    private String nom;
    private int id;
    //initialisation de la collection
    private List<Media> mediasEmpruntes;
//constructeur paramétré 
    public Membre(String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.mediasEmpruntes = new ArrayList<>();
    }
    //getter pour les noms
    public String getNom() {
        return nom;
    }
    //getter pour les ID
    public int getId() {
        return id;
    }
    //methode prenant en paramètre un objet de type MEDIA et permettant après verification if de son existance de celui ci de l'ajouter au media empruntés
    public void emprunterMedia(Media media) {
        if (media != null) {
            mediasEmpruntes.add(media);
        }
    }
//getter pour la collection List<Media>
    public List<Media> getMediasEmpruntes() {
        return mediasEmpruntes;
    }
//methode retournant une chaine de caractère
    @Override
    public String toString() {
        return "Membre{" + "nom='" + nom + "', id=" + id + "}";
    }

}
