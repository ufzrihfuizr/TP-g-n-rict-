public abstract class Media {
    //initialisation des variables utilisées dans la classe
    private String titre;
    private int anneePublication;
//constructeur non paramétré
    public Media() {
        this.titre = "";
        this.anneePublication = 0;
    }
//constructeur paramétré
    public Media(String titre, int anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
    }
//getter rendant possible l'acces à la variable privée titre
    public String getTitre() {
        return titre;
    }
//getter rendant possible l'acces à la variable privée titre année de parution
    public int getAnneePublication() {
        return anneePublication;
    }
//declaration de la methode getDescription accessible uniquement depuis ces sous classes
    public abstract String getDescription();
//declaration de la methode to string retournant en sortie une chaine de caractère indiquant le titre et l'année de parution
    @Override
    public String toString() {
        return titre + " (" + anneePublication + ")";
    }

}

