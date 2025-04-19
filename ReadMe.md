# Projet Aventure

## Introduction

Le but de ce projet est de permettre les déplacement d'un personnage sur une carte. Celle-ci est sous la forme d'un fichier .txt composé de 2 sortes de caractères.
- Les espaces représentent les cases sur lesquelles le persoonage peut se déplacer.
- Les diez (#) représentent les cases sur lesquelles le personnage ne peut pas se déplacer.
  Dans son fonctionnement, ce programme prendra en paramètre un fichier de deux lignes.
- La première ligne contient les coordonnées x et y du personnages ( 0,0 correspond à la case tout en haut à gauche de la carte.
- La second ligne contient les déplacemements que va opérer le personnage. Pour ce faire, nous allons utiliser un code NSEO (Nord, Sud, Est et Ouest) afin d'avoir des instructions claires.
  Dans le cas ou une instruction demande d'aller sur une case obstacle, cette instruction sera simplement ignoré.
  Le programme retournera les coordonnées du personnages après application des instructions.

