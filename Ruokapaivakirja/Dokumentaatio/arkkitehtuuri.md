# Arkkitehtuurikuvaus

## Rakenne

Käytössä on kolmitasoinen kerrosarkkitehtuuri. Kuvassa koodin pakkausrakenne.

<img src="https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/kuvat/arkkitehtuuri.png" width="160">
RuokapaivakirjaUi luo sovelluksen käyttöliittymän ja käyttää apuna MainViewController, DishViewController ja DishListView luokkia. 
Sovelluslogiikasta vastaavat MealService ja DishService jotka käyttävät luokkia Meal ja Dish. Tallennuksesta vastaavat DAO luokat ja tallennus tapahtuu SQLite tietokantaan.


## Käyttöliittymä
Käyttöliittymä on toteutettu JavaFX:n FXLM-formaatissa käyttäen Scenebuilderia ja se koostuu kolmesta eri näkymästä:
- Ruokasuunnitelman luonti näkymä
	- Suunnitelma on jaettu aterioihin
	- Aterialla on päivämäärä, ruokalaji ja kategoria

- Uuden ruokalajin luomis näkymä
	- Ruokalajilla on nimi, kalorit, hiilihydraatit, proteiinit, sokerit ja rasvat

- Raportti näkymä
	- Jossa näkyy syödyt ateriat

Kullakin on oma Controller luokka joka vastaa näkymän toiminnallisuudesta ja FXLM tiedosto joka vastaa
näkymien ulkonäöstä.


## Sovelluslogiikka

Meal ja Dish muodostavat sovelluksen datamallin ja ne kuvaavat aterioita sekä niillä nautittuja ruokalajeja.
Toiminnallisuuksista vastaavat luokat MealService ja DishServise.


## Tietojen tallennus

SqlMealDao ja SqlDishDao vastaavat tietojen tallentamisesta Sqlite tietokantaan. Niitä käytetään MealDao ja DishDao rajapintojen kautta.
Dish tallenetaan muodossa id INTEGER PRIMARY KEY, description TEXT NOT NULL, calories INTEGER, proteins REAL, carbs REAL, sugars REAL, fats REAL
Meal muodossa id INTEGER PRIMARY KEY, date DATE, mealdish INTEGER, category TEXT, done INTEGER, FOREIGN KEY (mealdish) REFERENCES dish(id)
Historia tieto saadaan Meal taulun done kentän perusteella. Jos Done on 0 niin ateria on aktiivinen ja jos se on 1 niin ateria on tallennettu.

## Päätoiminnallisuudet

**Ruokalajin luominen**

Käyttäjä syöttää ruokalajin tiedot ja painaa lisää painiketta dishService luokka vastaa ruokalajin luomisesta ja tallentamisesta DishDao luokan kautta.
<img src="https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/kuvat/createdish.png" width="2000">

**Aterian luominen**
Käyttäjä valitsee aterialle päivämäärän, kategorian ja ruokalajin sekä painaa tallenna nappia. MealService luokka vastaa aterian luomisesta ja tallentamisesta MealDao luokan kautta 
<img src="https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/kuvat/createmeal.png" width="200">
