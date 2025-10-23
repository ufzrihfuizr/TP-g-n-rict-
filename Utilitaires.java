import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utilitaires {

    //initialisation d'une methode static générique retournant l'ensemble des éléments présent au sein d'une liste de classe quelquonque <T>
    public static <T> void afficherListe(List<T> liste) {
        if (liste == null) return;
        for (T elt : liste) {
            //appelle implicitement la methode toString
            System.out.println(elt);
        }
    }

    //creation de la methode static générique <T> filtrer
    public static <T> List<T> filtrer(List<T> liste, Predicate<T> critere) {
        if (liste == null) return null;
        //convertit la collection en un flux de données compatibles aux methodes filter , collect
        return liste.stream()
                    .filter(critere) //filtrage par predicat
                    .collect(Collectors.toList()); //conversion inverse traduisant le flux convertit dans une nouvelle collection à l'aide de la methode toList()
    }
   
    // Cration de la methode static générique <T> copier collection
    public static <T> void copierCollection(Collection<T> source, Collection<T> destination) {
        if (source == null || destination == null) return;
        for (T elt : source) {
            destination.add(elt);
        }
    }

}

// Etape 7
 //méthode non abstraite appelant la methode getDescription
     public void afficherDetails() {
        System.out.println(getDescription());
    }
}




