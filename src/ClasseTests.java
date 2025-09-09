import java.io.IOException;

public class ClasseTests {
    private static final String FICHIER_TEST = "albums.txt";
    public static void main(String[] args) throws IOException {
        CollectionMusicale collection = new CollectionMusicale(FICHIER_TEST);

        System.out.println("Nombre albums distincts : " + collection.getNombreAlbumsDistincts());

        System.out.println("\nRecherche par artiste qui contient STON :");
        Album[] tabRechercheArtiste = collection.rechercherParArtiste("STON");
        for(int i = 0; i <= tabRechercheArtiste.length - 1; i++){
            System.out.println(tabRechercheArtiste[i]);
        }

        System.out.println("\nRecherche par titre qui contient can :");
        Album[] tabRechercheTitre = collection.rechercherParTitre("can");
        for(int i = 0; i <= tabRechercheTitre.length - 1; i++){
            System.out.println(tabRechercheTitre[i]);
        }

        System.out.println("\nRecherche par periode avec min 2000 et max 1995 (Retourne rien) :");
        Album[] tabRecherchePeriodeInvalide = collection.rechercherParPeriode(2000, 1995);
        for(int i = 0; i <= tabRecherchePeriodeInvalide.length - 1; i++){
            System.out.println(tabRecherchePeriodeInvalide[i]);
        }

        System.out.println("\nRecherche par periode entre 1995 et 2000 :");
        Album[] tabRecherchePeriode = collection.rechercherParPeriode(1995, 2000);
        for(int i = 0; i <= tabRecherchePeriode.length - 1; i++){
            System.out.println(tabRecherchePeriode[i]);
        }

        System.out.println("\nRecherche par annee 1997 :");
        Album[] tabRechercheAnnee = collection.rechercherParAnnee(1997);
        for(int i = 0; i <= tabRechercheAnnee.length - 1; i++){
            System.out.println(tabRechercheAnnee[i]);
        }

        System.out.println("\nRecherche par evaluation cents etoile (Devrait retourner null) :");
        Album[] tabRechercheEvalInvalide = collection.rechercherParEvaluation(100);
        for(int i = 0; i <= tabRechercheEvalInvalide.length - 1; i++){
            System.out.println(tabRechercheEvalInvalide[i]);
        }

        System.out.println("\nRecherche par evaluation une etoile (Only stinkers) :");
        Album[] tabRechercheEval = collection.rechercherParEvaluation(1);
        for(int i = 0; i <= tabRechercheEval.length - 1; i++){
            System.out.println(tabRechercheEval[i]);
        }

        System.out.println("\nRecherche par genres jeanprivat et bomba! (Devrait retourner null) :");
        Album[] tabRechercheGenreInvalide = collection.rechercherParGenres(new String[]{"jeanprivat", "bomba!"});
        for(int i = 0; i <= tabRechercheGenreInvalide.length - 1; i++){
            System.out.println(tabRechercheGenreInvalide[i]);
        }

        System.out.println("\nRecherche par genres FUN et disc :");
        Album[] tabRechercheGenre = collection.rechercherParGenres(new String[]{"FUN", "disc"});
        for(int i = 0; i <= tabRechercheGenre.length - 1; i++){
            System.out.println(tabRechercheGenre[i]);
        }

        System.out.println("\nRecherche moyenne evaluations de mikael yackson (Devrait retourner 0) :");
        System.out.println(collection.getMoyenneEvaluations("mikael yackson"));

        System.out.println("\nRecherche moyenne evaluations de Michael Jackson :");
        System.out.println(collection.getMoyenneEvaluations("Michael Jackson"));
    }
}
