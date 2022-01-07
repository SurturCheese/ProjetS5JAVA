# ProjetS5JAVA

La méthode main permettant l'exécution de l'application se trouve dans la classe App (fichier App.java)

#Dans le terminal en étant placé dans le dossier parent  du  dossier "projet" :
javac projet/*
java projet.app

Règle de notre jeu : 
  Victoire / perte :
    - Le joueur perd s'il n'a plus de vie
    - Le joueur gagne s'il a rammassé tout les pacgommes 
      ( donc après avoir changé de labyrinthe une fois )
  Pacgommes :
    - Pacgomme bleu : 100 points
    - Pacgomme violet : 300 points et pacman devient invisible
    - Pacgomme orange : 500 points et pacman devient superpacman (invincible)
    - Pacgomme vert : 100 change le labyrinthe
  Fantomes : 
    - Chaque fantôme se d´eplace dans une direction jusqu’a ce qu’il atteigne un mur, puis choisit une nouvelle
      direction aléatoirement
  Pacman :
    - Possède 3 vie au début et peux en gagne une de plus s'il atteint 5000 points
    - Devient invincible s'il mange un pacgomme orange
    - Devient invisible s'il mange un pacgomme violet
    - Si pacman prend un dégât alors tout les fantomes sont téléporté à leur point de départ 
      Fait pour éviter de prendre des dégats au moment où l'on réapparait

 Lien github : https://github.com/SurturCheese/ProjetS5JAVA
      
