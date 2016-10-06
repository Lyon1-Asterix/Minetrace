# Obsels collectés
## BlockBreakObsel
- start (int)
- blockName (string)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

## BlockPlaceObsel
- start (int)
- blockName (string)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

## CraftObsel
- start (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)
- resultType (string)
- resultData (byte)
- resultAmountByCraft (int)
- usedItems (List\<JSONableItem>)
- numberOfCrafts (int)

## DropItemObsel
- start (int)
- itemName (string)
- amount (int)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

## PickupItemObsel
- start (int)
- itemName (string)
- amount (int)
- data (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

## PlayerDamageObsel
- start (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)
- cause (string)
- damage (double)

## PlayerDeathObsel
- start (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)
- keepInventory (bool)

## PlayerJoinObsel
- start (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)

## PlayerKickObsel
- start (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)
- reason (string)

## PlayerQuitObsel
- start (int)
- x (int)
- y (int)
- z (int)
- dimension (string)
- playerName (string)
