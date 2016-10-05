# Minetrace
Un programme de collecte de traces sous Minecraft

## Pré-requis
Un serveur Spigot fonctionnel.

## Utilisation
Déplacer le .jar du répertoire "target" du dépôt au répertoire "plugin" du serveur.

La commande principale du programme est la commande *trace*. Celle-ci peut être lancée en jeu par un joueur admin ("/trace ..."), ou directement depuis la console serveur ("trace ...").

La documentation des commandes est disponible depuis la commande *help* ("/help trace" pour des informations sur la commande *trace*).
## Obsels collectés
### BlockBreakObsel
- start (int)
- blockName (string)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

### BlockPlaceObsel
- start (int)
- blockName (string)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

### DropItemObsel
- start (int)
- itemName (string)
- amount (int)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

### PickupItemObsel
- start (int)
- itemName (string)
- amount (int)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)
