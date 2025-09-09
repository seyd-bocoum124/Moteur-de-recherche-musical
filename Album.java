
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Cette classe modelise un album de musique.
 * Les methodes de cette classe ne valident pas leurs arguments, c'est donc a 
 * l'utilisateur de cette classe de s'assurer de leur validite.
 * 
 * @author Melanie Lord
 * @version H24
 */
public class Album {
   
   //----------------------
   // ATTRIBUTS D'INSTANCE
   //----------------------
   
   private int id;         //numero d'identification (unique) de cet album
   private String titre;   //titre de cet album
   private String artiste; //artiste ayant fait cet album
   private int annee;      //annee de sortie de cet album
   
   //Note appreciative sur 3 (0, 1, 2 ou 3). 0 signifie que cet album n'a pas
   //encore ete evalue. 3 est la meilleure note.
   private int evaluation; 
   
   //La liste des genres musicaux de cet album
   private List<String> genres = new ArrayList<>();
   
   //La liste des sous-genres musicaux de cet album (s'il y en a)
   private List<String> sousGenres = new ArrayList<>();
   
   /**
    * Constructeur d'initialisation qui construit un album avec les valeurs 
    * donnees en parametre. La liste des genres et celle des sous-genres sont
    * vides. Ceux-ci peuvent etre ajoutes par la suite, a cet album, en utilisant 
    * les methodes ajouterGenre et ajouterSousGenre.
    * 
    * ANTECEDENT : Tous les parametres sont valides.
    * 
    * @param id le numero d'identification de cet album
    * @param titre le titre de cet album
    * @param artiste l'artiste ayant fait cet album
    * @param annee l'annee de sortie de cet album
    * @param evaluation l'evaluation de cet album (entre 0 et 3)
    */
   public Album(int id, String titre, String artiste, int annee, int evaluation) {
      this.id = id;
      this.titre = titre;
      this.artiste = artiste;
      this.annee = annee;
      this.evaluation = evaluation;
   }
   
   /**
    * Retourne l'id de cet album.
    * @return l'id de cet album
    */
   public int getId() {
      return id;
   }

   /**
    * Permet de modifier l'id de cet album.
    * @param id le nouvel id a assigner a cet album.
    */
   public void setId(int id) {
      this.id = id;
   }

   /**
    * Retourne le titre de cet album.
    * @return le titre de cet album
    */
   public String getTitre() {
      return titre;
   }

   /**
    * Permet de modifier le titre de cet album.
    * @param titre le nouveau titre a assigner a cet album.
    */
   public void setTitre(String titre) {
      this.titre = titre;
   }

   /**
    * Retourne l'artiste de cet album.
    * @return l'artiste de cet album
    */
   public String getArtiste() {
      return artiste;
   }

   /**
    * Permet de modifier l'artiste de cet album.
    * @param artiste le nouvel artiste a assigner a cet album
    */
   public void setArtiste(String artiste) {
      this.artiste = artiste;
   }
   
   /**
    * Retourne l'annee de sortie de cet album.
    * @return l'annee de sortie de cet album
    */
   public int getAnnee() {
      return annee;
   }

   /**
    * Permet de modifier l'annee de sortie de cet album.
    * @param annee la nouvelle annee de sortie a assigner a cet album
    */
   public void setAnnee(int annee) {
      this.annee = annee;
   }

   /**
    * Retourne un iterateur pour iterer sur les genres musicaux de cet album.
    * @return un iterateur pour iterer sur les genres musicaux de cet album
    */
   public Iterator<String> iterateurGenres () {
      return genres.iterator();
   }
   
   /**
    * Retourne un iterateur pour iterer sur les sous-genres musicaux de cet album.
    * @return un iterateur pour iterer sur les sous-genres musicaux de cet album
    */
   public Iterator<String> iterateurSousGenres () {
      return sousGenres.iterator();
   }

   /**
    * Retourne l'evaluation de cet album (Note sur 3). 
    * Une evaluation egale a 0 signifie qu'il n'y a aucune evaluation.
    * @return l'evaluation de cet album
    */
   public int getEvaluation() {
      return evaluation;
   }

   /**
    * Permet de modifier l'evaluation de cet album.
    * @param evaluation la nouvelle evaluation a assigner a cet album
    */
   public void setEvaluation(int evaluation) {
      this.evaluation = evaluation;
   }
   
   /**
    * Ajoute le genre de musique donne a la liste des genres de cet album.
    * ANTECEDENT : le genre doit etre valide.
    * @param genre le genre a ajouter a cet album
    */
   public void ajouterGenre(String genre) {
      genres.add(genre);
   }
   
   /**
    * Ajoute le sous-genre de musique donne a la liste des sous-genres de cet album.
    * ANTECEDENT : le sousGenre doit etre valide.
    * @param sousGenre le sous-genre a ajouter a cet album.
    */
   public void ajouterSousGenre(String sousGenre) {
      sousGenres.add(sousGenre);
   }

   /**
    * Teste si cet album est egal a autreAlbum.
    * Deux albums a1 et a2 sont egaux si leurs titres sont egaux (sans tenir compte
    * de la casse), leurs artistes sont egaux (sans tenir compte de la casse), et 
    * leurs annees de sortie sont egales.
    * @param autreAlbum l'album a comparer avec cet album
    * @return true si cet album est egal a autreAlbum, false sinon
    */
   @Override
   public boolean equals(Object autreAlbum) {
      return this == autreAlbum
         || (autreAlbum != null && this.getClass() == autreAlbum.getClass()
         && this.artiste.toLowerCase().equals(((Album)autreAlbum).artiste.toLowerCase())
         && this.titre.toLowerCase().equals(((Album)autreAlbum).titre.toLowerCase())
         && this.annee == ((Album)autreAlbum).annee);
   }
   
   /**
    * Construit et retourne un hashcode pour cet album.  
    * Si deux albums a1 et a2 sont egaux (a1.equals(a2) retourne true), cette 
    * methode retourne le meme hashcode pour a1 et a2.
    * Note : 
    *    Cette methode est necessaire pour que l'utilisation de la methode 
    *    Stream.distinct() sur un stream d'albums fonctionne.
    *    (Vous n'avez pas a faire quoique ce soit)
    * @return un hashcode pour cet album 
    */
   @Override
   public int hashCode() {
      int hash = 17;
      hash = 31 * hash + Objects.hashCode(this.titre.toLowerCase());
      hash = 31 * hash + Objects.hashCode(this.artiste.toLowerCase());
      hash = 31 * hash + Objects.hashCode(this.annee);
      return hash;
   }
   
   /**
    * Retourne une representation sous forme de chaine de caracteres de cet album.
    * 
    * Exemple : 
    * 
    * 184. The Immaculate Collection - Madonna (1990) *** [Electronic, Pop][Synth-pop]
    * 
    *    - 184                         = id,
    *    - The immaculate Collection   = titre 
    *    - Madonna                     = artiste
    *    - 1990                        = annee de sortie
    *    - ***                         = evaluation (= 3)
    *    - Electronic, Pop             = 2 genres musicaux
    *    - Synth-pop                   = 1 sous-genre musical
    * 
    * @return une representation sous forme de chaine de caracteres de cet album
    */
   @Override
   public String toString() {
      return String.format("%-5s", id + ".") + titre + " - " + artiste 
         + " (" + annee + ")"+ evalToString() + genres + sousGenres;
   }
   
   
   //----------------------
   // METHODE PRIVEE
   //----------------------

   /**
    * Retourne une chaine de caracteres formees de 1, 2 ou 3 caracteres '*' lorsque 
    * l'evaluation de cet album est egale a respectivement 1, 2 ou 3. Retourne une
    * chaine vide si l'evaluation est egale a 0. 
    * 
    * @return une representation sous forme de chaine de caracteres de l'evaluation
    *         de cet album
    */
   private String evalToString() {
      String eval = "";
      
      if (evaluation > 0) {
         for (int i = 0 ; i < evaluation ; i++) {
            eval = eval + "*";
         }
         eval = " " + eval + " ";
      }
      return eval;
   }

}
