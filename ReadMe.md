# Projet Aventure

## Introduction

Le but de ce projet est de permettre les déplacements d'un personnage sur une carte. Celle-ci est sous la forme d'un fichier .txt composé de deux sortes de caractères.
- Les espaces représentent les cases sur lesquelles le personnage peut se déplacer.
- Les diez (#) représentent les cases sur lesquelles le personnage ne peut pas se déplacer.
  Dans son fonctionnement, ce programme prendra en paramètre un fichier de deux lignes.
- La première ligne contient les coordonnées x et y du personnage (0,0 correspond à la case tout en haut à gauche de la carte).
- La seconde ligne contient les déplacements que va opérer le personnage. Pour ce faire, nous allons utiliser un code NSEO (Nord, Sud, Est et Ouest) afin d'avoir des instructions claires.
  Dans le cas où une instruction demande d'aller sur une case obstacle, cette instruction sera simplement ignoré.
  Le programme retournera les coordonnées du personnage après application des instructions.

## Structure du projet

Les fichiers contenant le code du projet se situe dans le dossier suivant : /src/main/java/fr.mfraisse/  
Dedans, nous pouvons trouver 2 fichiers :
- Main.java : fichier principale du projet, il permet d'utiliser le projet comme demandé dans l'énoncé avec la possibilité de choisir son fichier "d'instructions" depuis un explorateur de fichier.
- Map.java : fichier contenant le code de notre classe Map. Celui-ci contient tout le code demandé dans l'introduction.
Ensuite, dans le répertoire /src/main/resources/, nous pouvons trouver 2 dossiers :
- instructions : contient les fichiers permettant de guider notre personnage sur la carte.
- maps : contient la carte sur laquelle le personnage peut se déplacer.  
Enfin, dans le répertoire /src/test/java/, nous pouvons voir le fichier MapTest.java contenant les tests unitaires de notre projet. En l'exécutant, nous pouvons vérifier si toutes les méthodes de la classe Map fonctionne comme attendu.
