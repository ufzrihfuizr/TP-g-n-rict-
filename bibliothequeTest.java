import java.util.*;
import java.util.function.Predicate;

public class BibliothequeTest {
    public static void main(String[] args) {
        // Initialisation des collections tousMedias , tousMembres , emprunts
        List<Media> tousMedias = new ArrayList<>();
        Set<Membre> tousMembres = new HashSet<>(); //Type permettant d'eviter la redondance et permettant l'insertion et le parcourt desordonné de chaque élément présent dans la collection
        Map<Membre, List<Media>> emprunts = new HashMap<>();//association de type Map réunissant les objets Membre et les objets List<Media> dans une variable emprunts avec pour identifians les valeurs des objets Membre

        // Création d'objets livre contenu dans des variables de type Livre avec pour clées un titre une date de parution un auteur ainsi qu'une quantité
        Livre livre1 = new Livre("Le Petit Prince", 1943, "Antoine de Saint‑Exupéry", 96);
        Livre livre2 = new Livre("1984", 1949, "George Orwell", 328);
        // Création d'objets Cd contenu dans des variables de type Cd avec pour clées un titre une date de parution un auteur ainsi qu'une quantité
        CD cd1 = new CD("Thriller", 1982, "Michael Jackson", 42);
        CD cd2 = new CD("New Album", 2015, "Some Artist", 50);
        //ajout de ces variables dans la collection tousMedia
        tousMedias.add(livre1);
        tousMedias.add(livre2);
        tousMedias.add(cd1);
        tousMedias.add(cd2);

        // Création de membres avec le constructeur parametré de la classe Membre et ajout de ces derniers dans une variable de type Membre 
        Membre alice = new Membre("Alice", 1);
        Membre bob   = new Membre("Bob", 2);
        Membre amanda= new Membre("Amanda", 3);
        //ajout de ces derniers dans une collection de type Set<Membre>
        tousMembres.add(alice);
        tousMembres.add(bob);
        tousMembres.add(amanda);

        // Chaque element de la collection tousMembres sera mis dans l'association d'objet Membre Media avec pour identifiant le nom des membres ajoutés
        for (Membre m : tousMembres) {
            emprunts.put(m, new ArrayList<>());
        }

        // test d'emprunts réalisés
        alice.emprunterMedia(livre1);
        emprunts.get(alice).add(livre1);

        alice.emprunterMedia(cd2);
        emprunts.get(alice).add(cd2);

        bob.emprunterMedia(cd1);
        emprunts.get(bob).add(cd1);

        amanda.emprunterMedia(livre2);
        emprunts.get(amanda).add(livre2);

        // Affichage des médias disponibles
        System.out.println("Médias disponibles :");
        Utilitaires.afficherListe(tousMedias);
        System.out.println();

        // Exemple de filtrage de médias parus après 2010
        List<Media> mediasApres2010 = Utilitaires.filtrer(
            tousMedias,
            m -> m.getAnneePublication() > 2010
        );
        System.out.println("Médias après 2010 :");
        Utilitaires.afficherListe(mediasApres2010);
        System.out.println();

        // Exemple de filtrage de membres dont le nom commençe par “A”
        List<Membre> membresCommencentA = Utilitaires.filtrer(
            new ArrayList<>(tousMembres),
            mb -> mb.getNom().startsWith("A") //fonction fléché prenant le paramètre inserer ici représenter "mb" pour réaliser le filtrage à l'aide de la methode startsWith()
        );
        System.out.println("Membres dont le nom commence par 'A' :");
        Utilitaires.afficherListe(membresCommencentA);
        System.out.println();

        // Étape 5 : Tri
        //  declalaration d'une variable de type Comparator<Media> compMedia
        Comparator<Media> compMedia = Comparator
            .comparingInt(Media::getAnneePublication).reversed() //Compare les dates de publications des medias (ordre croissant) par une methode utilisant une valeur de type Int 
            .thenComparing(Media::getTitre);//compare les titres des media retournés

        //trie les media present dans les collections tousMedias et compMedia
        Collections.sort(tousMedias, compMedia);
        System.out.println("Médias triés (année décroissante, puis titre) :");
        Utilitaires.afficherListe(tousMedias);
        System.out.println();

        // 2) Comparator pour Livre uniquement
        //déclaration d'une collection de type List<Livre> listelivres
        List<Livre> listeLivres = new ArrayList<>();
        //si un element m de tousMedias est une instance de la classe Livre (héritage) , il est ajouté à la collection listeLivres
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

        // Initialisation de la collection mediasEmpruntesSansDoublons
        Set<Media> mediasEmpruntesSansDoublons = new HashSet<>();
        //pour chaque element present dans l'association Map d'objets emprunts formés avec les même couples de clés , un ajout de ces erniers sont realisés dans la collection mediasEmpruntesSansDoublons
        for (Map.Entry<Membre, List<Media>> entry : emprunts.entrySet()) {
            mediasEmpruntesSansDoublons.addAll(entry.getValue());
        }
        //affichage des medias sans doublon
        System.out.println("Tous les médias empruntés (sans doublons) :");
        Utilitaires.afficherListe(new ArrayList<>(mediasEmpruntesSansDoublons));
        System.out.println();

        // 3) Filtrage polymorphe (seulement Livre) | filtre tous les livres issus de la classe Livre à l'aide de la methode filtrer et affiche ces derniers à l'aide de la methode afficherListe d'utilitaires
        //declaration de la collection de type List<Media> seulementLivres
        List<Media> seulementLivres = Utilitaires.filtrer(
            tousMedias,
            m -> m instanceof Livre
        );
        System.out.println("Uniquement les livres :");
        Utilitaires.afficherListe(seulementLivres);
        System.out.println();

        // Copie de collection 
        //declaration de la collection List<Media> copieMedias
        List<Media> copieMedias = new ArrayList<>();
        Utilitaires.copierCollection(tousMedias, copieMedias);//copie des elements à l'aide de la methode copierCollection d'utilitaires present dans la collection tousMedia dans la collection copieMedias
        System.out.println("Copie de la collection de médias :");//affichage de la collection copiée
        Utilitaires.afficherListe(copieMedias);
    }

}

