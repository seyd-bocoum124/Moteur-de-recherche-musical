# 🎶 CollectionMusicale

Ce projet Java permet de gérer une collection d’albums musicaux en important des données depuis un fichier texte.  
Il exploite les **Streams Java 8+** pour filtrer, traiter et manipuler les données.

---

## 📂 Structure du projet

- **CollectionMusicale.java** : classe principale qui lit un fichier d’albums et initialise la collection.
- **Album.java** *(non inclus ici, mais attendu)* : classe représentant un album (titre, artiste, année, etc.).

---

## ⚙️ Fonctionnalités principales

- Lecture d’un fichier texte contenant des informations d’albums.
- Filtrage des lignes invalides ou vides.
- Conversion des données en objets `Album`.
- Stockage des albums dans une `List<Album>`.
- Manipulation via **Streams API** (`map`, `filter`, `collect`, etc.).

---

## 🚀 Exécution

1. **Compiler le projet**  
   Dans un terminal, placez-vous dans le dossier du projet et lancez :

   ```bash
   javac CollectionMusicale.java Album.java
   ```

2. **Exécuter**  
   Fournissez le chemin du fichier contenant les albums en paramètre :

   ```bash
   java CollectionMusicale albums.txt
   ```

---

## 📄 Format attendu du fichier d’albums

Chaque ligne doit contenir les informations d’un album, séparées par un délimiteur (par exemple `;`).  
Exemple :

```
Pink Floyd;The Dark Side of the Moon;1973
Daft Punk;Discovery;2001
Nirvana;Nevermind;1991
```

---

## 🛠️ Technologies utilisées

- **Java 8+**  
- **API Streams** (`map`, `filter`, `collect`)  
- **NIO Files & Paths** pour la lecture des fichiers

---

## 📌 Améliorations possibles

- Ajouter une interface CLI pour rechercher des albums (par artiste, par année, etc.).
- Exporter la collection vers JSON
