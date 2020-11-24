# Ruokapäiväkirja
Sovelluksen avulla on mahdollista pitää ruokapäiväkirjaa 

## Dokumentaatio
[tuntikirjanpito.md](https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/tuntikirjanpito.md)

[vaatimusmaarittely.md](https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/vaatimusmaarittely.md)

[arkkitehtuuri.md](https://github.com/Jarkkorm/ot-harjoitustyo/blob/master/Ruokapaivakirja/Dokumentaatio/arkkitehtuuri.md)

## Komentorivitoiminnot

Ohjelman saa suoritettua komennolla

```
mvn compile exec:java -Dexec.mainClass=ruokapaivakirja.Main
```

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```
