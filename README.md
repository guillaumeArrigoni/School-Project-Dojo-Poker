<h2 align="center">Dojo - La main de Poker</h2>
<h3 align="center">PS5 - Projet de développement S5</h3>

- **Notre équipe GLYK est composé de :**

  - Guillaume ARRIGONI

  - Loris DRID

  - Yacine MERIOUA

  - Karim CHARLEUX

## Sommaire
1. [État du projet](#1-état-du-projet)
2. [Comment exécuter le programme](#2-comment-exécuter-le-programme)
3. [Comment exécuter les tests](#3-comment-exécuter-les-tests)
4. [Comment jouer](#4-comment-jouer)
5. [Description des règles](#5-description-des-règles)

## 1. État du projet
Projet terminé, toutes les slices ont étaient développées. Le code lui reste tout de même perfectible. 

## 2. Comment exécuter le programme
Pour exécuter le programme, il faut run la classe **[src/gamepoker/GamePoker.java](https://github.com/pns-si3-projects/dojo-poker-22-23-ps5-22-23-poker-d/blob/56255b6f76f855778ab115616c95ac78fd914760/src/gamepoker/GamePoker.java).**

<img src="https://i.ibb.co/Fq33BZF/image.png" alt="exécuter le programme" width="350"/>

## 3. Comment exécuter les tests
Pour exécuter les programmes, il faut run les classes de test situé dans **[Test/gamepoker/*.java](https://github.com/pns-si3-projects/dojo-poker-22-23-ps5-22-23-poker-d/tree/56255b6f76f855778ab115616c95ac78fd914760/Test/gamepoker)**

<img src="https://i.ibb.co/hH8tTbx/test.jpg" alt="exécuter les tests" width="350"/>

## 4. Comment jouer
Une fois le [programme exécuté](#2-comment-exécuter-le-programme) on peut jouer via la console.

Il suffit de rentrer les cartes manuellement avec le clavier séparées par des espaces comme ceci :
```
The cards of player 1 : 2Tr 6Ca 7Ca 8Tr APi
The cards of player 2 : 3Tr 5Ca 5Co DCo RCo

The player 2 win with a double pair of 5
```
Ensuite le vainqueur est affiché avec sa combinaison

## 5. Description des règles
Une main de poker comprend 5 cartes tirées d’un seul jeu de 52 cartes. Chaque carte a une couleur, Trèfle, Carreau, Cœur, Pique (dénotée Tr, Ca, Co, Pi) et une valeur parmi 2, 3, 4, 5, 6, 7, 8, 9, 10, valet, dame, roi, as (dénotée 2, 3, 4, 5, 6, 7, 8, 9, 10, V, D, R, A). Pour le calcul du score, toutes les couleurs ont le même niveau, par exemple l’as de carreau n’est pas battu par l’as de pique, ils sont égaux. Les valeurs sont ordonnées comme définies précédemment, le 2 étant la plus petite valeur et l’as la plus grande.

Une main de poker est faite de 5 cartes. Dans le texte ci-dessous, les mains sont classées de la plus faible à la plus forte :
* **Plus haute carte :** les mains qui ne correspondent à aucune autre catégorie sont classées par la valeur de leur plus haute carte. Si les plus hautes cartes ont la même valeur, les mains sont classées par la plus haute suivante et ainsi de suite.
* **Paire :** 2 des 5 cartes de la main ont la même valeur. Deux mains qui contiennent une paire sont classées par la valeur des cartes formant la paire. Si les valeurs sont les mêmes, les mains sont classées par les cartes hors de la paire, en ordre décroissant.
* **Deux paires :** La main contient deux paires différentes. Les mains qui contiennent deux paires sont classées par la valeur de la paire la plus élevée. Deux mains avec la paire la plus élevée de même valeur sont classées par l’autre paire. Si ces valeurs sont les mêmes, les mains sont classées par la valeur de la carte restante.
* **Brelan :** 3 cartes dans la main ont la même valeur. Deux mains avec un brelan sont classées par la valeur des 3 cartes.
* **Suite :** 5 cartes de valeurs consécutives. Deux suites sont classées par la valeur de leur carte la plus élevée.
* **Couleur :** La main contient 5 cartes de la même couleur. Deux mains “couleur” sont classées par les règles de la carte la plus élevée.
* **Full :** La main contient 3 cartes de la même valeur avec les 2 cartes formant une paire, le classement se fait par la valeur des 3 cartes.
* **Carré :** 4 cartes de la même valeur, classement par la valeur des 4 cartes.
* **Quinte Flush :** 5 cartes de la même couleur avec des valeurs consécutives, classement par la carte la plus élevée dans la main.




