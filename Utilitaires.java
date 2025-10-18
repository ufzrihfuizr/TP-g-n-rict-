import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utilitaires {

    // Étape 4.1 : afficherListe
    public static <T> void afficherListe(List<T> liste) {
        if (liste == null) return;
        for (T elt : liste) {
            System.out.println(elt);
        }
    }

    // Étape 4.2 : filtrer
    public static <T> List<T> filtrer(List<T> liste, Predicate<T> critere) {
        if (liste == null) return null;
        return liste.stream()
                    .filter(critere)
                    .collect(Collectors.toList());
    }

    // Étape 6.1 : copierCollection
    public static <T> void copierCollection(Collection<T> source, Collection<T> destination) {
        if (source == null || destination == null) return;
        for (T elt : source) {
            destination.add(elt);
        }
    }
}