# Minetrace
Un programme de collecte de traces sous Minecraft

## Pré-requis
Un serveur Spigot fonctionnel.

## Utilisation
Déplacer le .jar du répertoire "target" du dépôt au répertoire "plugin" du serveur.

La commande principale du programme est la commande *trace*. Celle-ci peut être lancée en jeu par un joueur admin ("/trace ..."), ou directement depuis la console serveur ("trace ...").

La documentation des commandes est disponible depuis la commande *help* ("/help trace" pour des informations sur la commande *trace*).

Les obsels créés sont décrits dans OBSELS.md

## Récupération des fichiers
Les fichiers se situe dans le repertoire de votre serveur Spigot :

`{spigotRepository}/plugins/minetrace`

## Build
Pour build le projet, utilisez la commande MAven suivante :
`mvn package`

Ou utilisez votre IDE favoris.