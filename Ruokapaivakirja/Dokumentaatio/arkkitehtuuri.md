# Arkkitehtuurikuvaus

## Rakenne

Käytössä on kolmitasoinen kerrosarkkitehtuuri. Kuvassa koodin pakkausrakenne.

<img src="https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/kuvat/arkkitehtuuri.png" width="160">
RuokapaivakirjaUi luo sovelluksen käyttöliittymän ja käyttää apuna MainViewController, DishViewController ja DishListView luokkia. Sovelluslogiikasta vastaavat MealService ja DishService jotka käyttävät luokkia Meal ja Dish. Tallennuksesta vastaavat DAO luokat ja tallennus tapahtuu SQLite tietokantaan.


## Käyttöliittymä
Käyttöliittymä on toteutettu JavaFX:n FXLM-formaatissa käyttäen Scenebuilderia ja se koostuu kahdesta eri näkymästä:
- Ruokasuunnitelman luonti
- Uuden ruokalajin luominen

Kummallakin on oma Controller luokka joka vastaa näkymän toiminnallisuudesta ja FXLM tiedosto joka vastaa
näkymien ulkonäöstä.


## Sovelluslogiikka
Meal ja Dish muodostavat sovelluksen datamallin ja toiminnallisuuksista vastaavat luokat MealService ja DishServise.


## Tietojen tallennus

SqlMealDao ja SqlDishDao vastaavat tietojen tallentamisesta tietokantaan.


## Päätoiminnallisuudet

**Ruokalajin luominen**

<img src="https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/kuvat/createdish.png" width="160">
