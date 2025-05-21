# souls-npcs
University project using Kotlin with Spring Boot

I need to write a proper documentation later on, for now, here are the routes:
- /api/v1/npcs (GET and POST)
- /api/v1/npcs/{id} (GET by ID and PUT)
- /api/v1/npcs/search?name= (GET by name in alphabetical order)
- /api/v1/npcs/search?game= (GET by game)

JSON body example (POST /api/v1/npcs):
```json
{
  "name": "npc test",
  "birthLand": "dickson",
  "occupation": "holder",
  "lore": "He is a holder from dickson",
  "game": "Dark Souls 1",
  "manyGames": true,
  "games": [
    "Dark Souls 1",
    "Dark Souls 2",
    "Dark Souls 3"
  ]
}
```

JSON body response example:
```json
{
  "id": 3,
  "name": "npc test",
  "birthLand": "dickson",
  "occupation": "holder",
  "lore": "He is a holder from dickson",
  "game": "Dark Souls 1",
  "manyGames": true,
  "games": [
    "Dark Souls 1",
    "Dark Souls 2",
    "Dark Souls 3"
  ]
}
```
