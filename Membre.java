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
    //getter rendant possible l'acces à la variable privée noms
    public String getNom() {
        return nom;
    }
    //getter rendant possible l'acces à la variable privée ID
    public int getId() {
        return id;
    }
    //methode prenant en paramètre un objet de type MEDIA et permettant après verification if de son existance de celui ci de l'ajouter au media empruntés
    public void emprunterMedia(Media media) {
        if (media != null) {
            mediasEmpruntes.add(media);
        }
    }
//getter rendant possible l'acces à la collection privée List<Media>
    public List<Media> getMediasEmpruntes() {
        return mediasEmpruntes;
    }
//ecrasement de la valeur precedemment retournée après instanciation de la methode toString par un nouvel ensemble de charactères retournés
    @Override
    public String toString() {
        return "Membre{" + "nom='" + nom + "', id=" + id + "}";
    }

}

