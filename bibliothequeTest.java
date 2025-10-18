import java.util.*;
import java.util.function.Predicate;

public class BibliothequeTest {
    public static void main(String[] args) {
        // Collections
        List<Media> tousMedias = new ArrayList<>();
        Set<Membre> tousMembres = new HashSet<>();
        Map<Membre, List<Media>> emprunts = new HashMap<>();

        // Création médias
        Livre livre1 = new Livre("Le Petit Prince", 1943, "Antoine de Saint‑Exupéry", 96);
        Livre livre2 = new Livre("1984", 1949, "George Orwell", 328);
        CD cd1 = new CD("Thriller", 1982, "Michael Jackson", 42);
        CD cd2 = new CD("New Album", 2015, "Some Artist", 50);

        tousMedias.add(livre1);
        tousMedias.add(livre2);
        tousMedias.add(cd1);
        tousMedias.add(cd2);

        // Création membres
        Membre alice = new Membre("Alice", 1);
        Membre bob   = new Membre("Bob", 2);
        Membre amanda= new Membre("Amanda", 3);

        tousMembres.add(alice);
        tousMembres.add(bob);
        tousMembres.add(amanda);

        // Initialiser la map d’emprunts
        for (Membre m : tousMembres) {
            emprunts.put(m, new ArrayList<>());
        }

        // Emprunts
        alice.emprunterMedia(livre1);
        emprunts.get(alice).add(livre1);

        alice.emprunterMedia(cd2);
        emprunts.get(alice).add(cd2);

        bob.emprunterMedia(cd1);
        emprunts.get(bob).add(cd1);

        amanda.emprunterMedia(livre2);
        emprunts.get(amanda).add(livre2);

        // Affichage médias
        System.out.println("Médias disponibles :");
        Utilitaires.afficherListe(tousMedias);
        System.out.println();

        // Exemple filtrage médias après 2010
        List<Media> mediasApres2010 = Utilitaires.filtrer(
            tousMedias,
            m -> m.getAnneePublication() > 2010
        );
        System.out.println("Médias après 2010 :");
        Utilitaires.afficherListe(mediasApres2010);
        System.out.println();

        // Exemple filtrage membres nom commençant par “A”
        List<Membre> membresCommencentA = Utilitaires.filtrer(
            new ArrayList<>(tousMembres),
            mb -> mb.getNom().startsWith("A")
        );
        System.out.println("Membres dont le nom commence par 'A' :");
        Utilitaires.afficherListe(membresCommencentA);
        System.out.println();

        // Étape 5 : Tri
        // 1) Comparator pour Media
        Comparator<Media> compMedia = Comparator
            .comparingInt(Media::getAnneePublication).reversed()
            .thenComparing(Media::getTitre);

        Collections.sort(tousMedias, compMedia);
        System.out.println("Médias triés (année décroissante, puis titre) :");
        Utilitaires.afficherListe(tousMedias);
        System.out.println();

        // 2) Comparator pour Livre uniquement
        List<Livre> listeLivres = new ArrayList<>();
        for (Media m : tousMedias) {
            if (m instanceof Livre) {
                listeLivres.add((Livre) m);
            }
        }
        Comparator<Livre> compLivre = Comparator
            .comparing(Livre::getAuteur)
            .thenComparing(Media::getTitre);
        Collections.sort(listeLivres, compLivre);
        System.out.println("Livres triés (auteur puis titre) :");
        Utilitaires.afficherListe(listeLivres);
        System.out.println();

        // Étape 6 : Défis avancés
        // 2) Médias empruntés sans doublons
        Set<Media> mediasEmpruntesSansDoublons = new HashSet<>();
        for (Map.Entry<Membre, List<Media>> entry : emprunts.entrySet()) {
            mediasEmpruntesSansDoublons.addAll(entry.getValue());
        }
        System.out.println("Tous les médias empruntés (sans doublons) :");
        Utilitaires.afficherListe(new ArrayList<>(mediasEmpruntesSansDoublons));
        System.out.println();

        // 3) Filtrage polymorphe (seulement Livre)
        List<Media> seulementLivres = Utilitaires.filtrer(
            tousMedias,
            m -> m instanceof Livre
        );
        System.out.println("Uniquement les livres :");
        Utilitaires.afficherListe(seulementLivres);
        System.out.println();

        // 1) Copier collection (exemple)
        List<Media> copieMedias = new ArrayList<>();
        Utilitaires.copierCollection(tousMedias, copieMedias);
        System.out.println("Copie de la collection de médias :");
        Utilitaires.afficherListe(copieMedias);
    }
}