public class Membre {
    private String nom;
    private int id;
    private List<Media> mediasEmpruntes;

    public Membre(String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.mediasEmpruntes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void emprunterMedia(Media media) {
        if (media != null) {
            mediasEmpruntes.add(media);
        }
    }

    public List<Media> getMediasEmpruntes() {
        return mediasEmpruntes;
    }

    @Override
    public String toString() {
        return "Membre{" + "nom='" + nom + "', id=" + id + "}";
    }
}