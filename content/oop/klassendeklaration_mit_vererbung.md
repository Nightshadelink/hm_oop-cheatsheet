---
title: "Klassen Deklaration mit Vererbung"
---

```java
class Auto extends Fahrzeug {
  private String nummernSchild;

  public void abs(){
    // code
  }
}
```
* Die Klasse `Auto` ist eine Unterklasse von der Klasse `Fahrzeug` (Spezialisierung)
* Die Klasse `Auto` übernimmt automatisch alle Funktionen und Attribute der Klasse `Fahrzeug`
* Die Klasse `Auto` kann die Funktionen der Klasse `Fahrzeug` erweitern und/oder überschreiben
* mit `super` können Methoden und Variablen der Basis-Klasse direkt aufgerufen werden
  * dies gilt auch für den Konstruktor
#### Konstruktoren

* Jede Klasse hat automatisch einen gleichnamigen Konstruktor
  * dieser kann explizt sein (angegeben) oder implizit (nicht angegeben) sein
* Der Konstruktor wird automatisch beim Erstellen eines Objekt ausgeführt
* Konstruktoren haben keinen `return` Wert


**Beispiel:**
```java
public class Fahrzeug {
  private String name;

  // Konstruktor ohne Argumente
  public Fahrzeug(){
    // code
  }

  // Konstruktor mit Argumenten
  public Fahrzeug(String name){
    // code
    this.name = name;
  }

}
```
