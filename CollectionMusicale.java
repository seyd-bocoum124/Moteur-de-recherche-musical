import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Une classe représentant une collection musicale contenant une liste d'albums.
 * Cette classe permet de charger des albums à partir d'un fichier, de rechercher des albums
 * par différents critères, et de calculer des statistiques sur la collection musicale.
 * <p>
 * Chaque album est représenté par un objet de type Album, et la collection est représentée
 * par une liste d'albums.
 * </p>
 * @author SEYDINA BOCOUM
 * */
public class CollectionMusicale {

    //----------------------
    // ATTRIBUTS D'INSTANCE
    //----------------------
    List<Album> albums = new ArrayList<>();


    /**
     * Constructeur de la classe CollectionMusicale.
     * Initialise une collection musicale à partir d'un fichier d'albums donné.
     *
     * @param ficAlbums Le chemin du fichier contenant les informations sur les albums.
     */
    public CollectionMusicale(String ficAlbums) {
        // Initialise une liste pour stocker les albums
        List<Album> albumsList = new ArrayList<>();
        String line;
        String[] parties;
        int id;
        int annee;
        String titre;
        String artiste;
        int evaluation;
        String[] genres;
        List<String> genresList;
        String[] sousGenres;
        List<String> sousGenresList;
        Album album;

        // Vérification si le nom du fichier est non null
        if (ficAlbums != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(ficAlbums))) {
                // Lecture du fichier ligne par ligne
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty() && !line.startsWith("#")) {
                        // Parsing des informations sur chaque album à partir des lignes du fichier
                        parties = line.split("\\|");
                        id = Integer.parseInt(parties[0]);
                        annee = Integer.parseInt(parties[1]);
                        titre = parties[2];
                        artiste = parties[3];
                        evaluation = Integer.parseInt(parties[4]);
                        genres = parties[5].split(",");
                        genresList = new ArrayList<>();
                        for (String genre : genres) {
                            genresList.add(genre.trim());
                        }
                        sousGenresList = new ArrayList<>();
                        if (parties.length > 6) {
                            sousGenres = parties[6].split(",");
                            for (String sousGenre : sousGenres) {
                                sousGenresList.add(sousGenre.trim());
                            }
                        }
                        // Création et initialisation d'un objet Album
                        album = new Album(id, titre, artiste, annee, evaluation);
                        for (String genre : genresList) {
                            album.ajouterGenre(genre);
                        }
                        for (String sousGenre : sousGenresList) {
                            album.ajouterSousGenre(sousGenre);
                        }
                        albumsList.add(album);
                    }
                }
            } catch (IOException ignored) {

            }
        }

        // Assignation de la liste d'albums à l'attribut d'instance
        this.albums.addAll(albumsList);
    }


    /**
     * Méthode pour obtenir le nombre d'albums distincts
     * @return
     */
    public int getNombreAlbumsDistincts() {
        return (int) albums.stream().distinct().count();
    }

    /**
     * Recherche des albums dans la collection par artiste.
     * Cette méthode permet de rechercher tous les albums dont l'artiste correspond en partie ou en totalité
     * au nom spécifié, sans tenir compte de la casse.
     *
     * @param artiste Le nom partiel ou complet de l'artiste à rechercher.
     * @return Un tableau d'objets Album contenant les albums dont l'artiste correspond en partie ou en totalité
     *         au nom spécifié, ou un tableau vide si aucun album ne correspond aux critères de recherche.
     */
    public Album[] rechercherParArtiste(String artiste) {
        Album[] albumsRecherches = new Album[0];
        if (artiste != null) {
            // Filtrage des albums par artiste et tri par titre
            albumsRecherches = albums.stream()
                    .filter(album -> album.getArtiste().toLowerCase().contains(artiste.toLowerCase()))
                    .distinct()
                    .sorted(Comparator.comparing(album -> album.getTitre().toLowerCase()))
                    .toArray(Album[]::new);
        }
        return albumsRecherches;
    }

    /**
     * Recherche des albums dans la collection par titre.
     * Cette méthode permet de rechercher tous les albums dont le titre contient le titre spécifié,
     * sans tenir compte de la casse.
     *
     * @param titre Le titre des albums recherchés.
     * @return Un tableau d'objets Album contenant les albums dont le titre contient le titre donné
     *     en paramètre, ou un tableau vide si aucun album ne correspond aux critères de recherche.
     */
    public Album[] rechercherParTitre(String titre) {
        Album[] albumsTrouves = new Album[0];
        if (titre != null) {
            // Filtrage des albums par titre et tri par titre
            albumsTrouves = albums.stream()
                    .filter(album -> album.getTitre().toLowerCase().contains(titre.toLowerCase()))
                    .distinct()
                    .sorted(Comparator.comparing(album -> album.getTitre().toLowerCase()))
                    .toArray(Album[]::new);
        }
        return albumsTrouves;
    }

    /**
     * Recherche des albums dans la collection par période.
     * Cette méthode permet de rechercher les albums sortis dans une période donnée, spécifiée par une
     * année minimale et une année maximale inclusives.
     *
     * @param anneeMin L'année minimale de la période de recherche.
     * @param anneeMax L'année maximale de la période de recherche.
     * @return Un tableau d'objets Album contenant les albums sortis dans la période spécifiée,
     *         ou un tableau vide si aucun album ne correspond aux critères de recherche.
     * @throws IllegalArgumentException Si l'année minimale est supérieure à l'année maximale.
     */
    public Album[] rechercherParPeriode(int anneeMin, int anneeMax) {
        Album[] albumsRecherches = new Album[0];
        if (anneeMin <= anneeMax) {
            // Filtrage des albums par période et tri par année
            albumsRecherches = albums.stream()
                    .filter(album -> album.getAnnee() >= anneeMin && album.getAnnee() <= anneeMax)
                    .distinct()
                    .sorted(Comparator.comparingInt(Album::getAnnee))
                    .toArray(Album[]::new);
        }
        return albumsRecherches;
    }

    /**
     * Recherche des albums dans la collection par année de sortie.
     *
     * @param annee L'année de sortie des albums recherchés.
     * @return Un tableau d'objets Album contenant les albums dont l'année de sortie est égale à l'année donnée en paramètre,
     *         ou un tableau vide si aucun album ne correspond aux critères de recherche.
     */
    public Album[] rechercherParAnnee(int annee) {
        return albums.stream()
                    .filter(album -> album.getAnnee() == annee)
                    .distinct()
                    .sorted(Comparator.comparing( album -> album.getTitre().toLowerCase()))
                    .toArray(Album[]::new);

    }

    /**
     * Recherche des albums dans la collection par évaluation.
     *
     * @param eval L'évaluation des albums recherchés.
     * @return Un tableau d'objets Album contenant les albums dont l'évaluation est égale à l'évaluation donnée en paramètre,
     *         ou un tableau vide si aucun album ne correspond aux critères de recherche.
     */
    public Album[] rechercherParEvaluation(int eval) {
        return albums.stream()
                .filter(album -> album.getEvaluation() == eval)
                .distinct()
                .sorted(Comparator.comparing( album -> album.getTitre().toLowerCase()))
                .toArray(Album[]::new);
    }

    /**
     * Recherche les albums de la collection ayant comme genres OU sous-genres
     * TOUS les genres contenus dans le tableau passé en paramètre.
     *
     * @param genres Un tableau contenant les genres avec lesquels on désire faire la recherche.
     * @return Un tableau contenant tous les albums de cette collection qui ont comme genres OU
     *         sous-genres TOUS les genres contenus dans le tableau passé en paramètre.
     */
    public Album[] rechercherParGenres(String[] genres) {
        Album[] albumsTrouves = new Album[0];
        if (genres != null && genres.length > 0) {
            albumsTrouves = albums.stream()
                    .filter(album -> allGenresMatch(album, genres))
                    .distinct()
                    .sorted(Comparator.comparing(album -> album.getTitre().toLowerCase()))
                    .toArray(Album[]::new);
        }
        return albumsTrouves;
    }

    /**
     * Vérifie si tous les genres spécifiés sont présents dans l'album.
     *
     * @param album L'album à vérifier.
     * @param genres Les genres à rechercher dans l'album.
     * @return true si tous les genres spécifiés sont présents dans l'album, sinon false.
     */
    private boolean allGenresMatch(Album album, String[] genres) {
        // Vérifie si tous les genres spécifiés sont présents dans l'album
        return Arrays.stream(genres)  // Crée un stream à partir du tableau de genres
                .filter(Objects::nonNull)  // Filtre les genres non nuls
                .allMatch(genre -> albumContainsGenreOrSubGenre(album, genre));  // Vérifie si tous les genres sont présents dans l'album
    }

    /**
     * Vérifie si l'album contient le genre spécifié.
     *
     * @param album L'album à vérifier.
     * @param genre Le genre à rechercher dans l'album.
     * @return true si l'album contient le genre spécifié, sinon false.
     */
    private boolean albumContainsGenreOrSubGenre(Album album, String genre) {
        // Crée des itérateurs pour parcourir les genres et sous-genres de l'album
        Iterator<String> genresIterator = album.iterateurGenres();
        Iterator<String> sousGenresIterator = album.iterateurSousGenres();

        // Initialise une variable pour indiquer si le genre est trouvé dans l'album
        boolean contientGenre = false;

        // Parcours des genres de l'album
        while (!contientGenre && genresIterator.hasNext()) {
            contientGenre = genresIterator.next().equalsIgnoreCase(genre);
        }

        // Parcours des sous-genres de l'album
        while (!contientGenre && sousGenresIterator.hasNext()) {
            contientGenre = sousGenresIterator.next().equalsIgnoreCase(genre);
        }

        // Retourne true si le genre a été trouvé, sinon false
        return contientGenre;
    }


    /**
     * Calcule la moyenne des évaluations des albums d'un artiste donné.
     *
     * @param artiste L'artiste dont les albums sont utilisés pour calculer la moyenne des évaluations.
     * @return La moyenne des évaluations de tous les albums de l'artiste donné, ou 0 s'il n'y a aucun album de cet artiste.
     */
    public double getMoyenneEvaluations(String artiste) {
        // Vérification si l'argument artiste est null ou vide
        if (artiste == null || artiste.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'artiste ne peut pas être null ou vide.");
        }

        // Convertir le nom de l'artiste en minuscule pour faciliter la comparaison
        String artisteLowerCase = artiste.toLowerCase();

        // Calculer la moyenne des évaluations pour les albums de l'artiste spécifié
        OptionalDouble moyenneEvaluations = albums.stream()
                .filter(album -> album.getArtiste().toLowerCase().equals(artisteLowerCase))
                .mapToDouble(Album::getEvaluation)
                .average();

        // Retourner la moyenne des évaluations s'il existe des albums, sinon retourner 0
        return moyenneEvaluations.orElse(0);
    }

}
