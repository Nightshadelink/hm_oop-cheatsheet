---
title: "Polymorphismus"
---

* Die _Vielfältigkeit_ bei der Objekte in verschiedenen Situationen verschieden reagieren können
#### Variante 1: Methodenüberladung
* Deklaration einer Methode mit verschiedenen übergabe Parametern
* je nachdem mit wie viel Parametern die Methode aufgerufen wird, verändert sie das _Verhalten_ der Klasse

```java
public class Fahrzeug {
  private String name;

  // Methode ohne Argumente
  public faehrt(){
    // code
  }

  // Methode mit Argumenten
  public faehrt(String Richtung){
    // code
  }

  // Methode mit Argumenten
  public faehrt(String Richtung, int Geschwindigkeit){
    // code
  }

}
```
#### Variante 2: Methodenüberschreibung
* Die Subklasse (Kindklasse) kann Methoden der Basisklasse (Eltern-Klasse) überschreiben

> Basis-Klasse Fahrzeug
```java
public class Fahrzeug {
  private String name;

  // Methode ohne Argumente
  public faehrt(){
    // code
    System.out.println("Das Fahrzeug fährt");
  }
}
```

> Sub-Klasse erbt alle Funktionen und überschreibt die "faehrt" Methode
```java
public class Auto implements Fahrzeug{

  @Override
  public void faehrt(){
    System.out.println("Das Auto fährt");
  }

}
```

> Beispiel aufruf
```java
// Basis-Klasse
// gibt "Das Fahrzeug fährt" auf der Konsole aus
Fahrzeug fahrzeug = new Fahrzeug();
fahrzeug.faehrt();

// Sub-Klasse
// gibt "Das Auto fährt" auf der Konsole aus
Fahrzeug auto = new Auto();
auto.faehrt();
```