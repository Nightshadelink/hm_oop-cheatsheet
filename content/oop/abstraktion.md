---
title: "Abstraktion"
---

* Abstraktion _versteckt_ Implementierungsdetails und gibt nur die Schnittstellen bekannt
* Erbende Klasse müssen diese Schnittstellen selbst implementieren
* Abstraktionen können sein:
  1. Abstract Class
  2. Interface
  3. Abstract Methods (in einer Klasse)

#### Abstract Class
* Eine _abstract class_ muss mit dem Schlüsselwort `abstract` deklariert werden
* Die Klasse kann `abstract` und `non-abstract` Methoden beinhalten
* Kann nicht Initialisiert werden
* Kann Konstruktoren und `static` Methoden beinhalten


```java
abstract class Blume{
  // Abstrakte Methode "duft()" - muss dann von jeder Subklasse implementiert werden
  abstract String duft();

  // nicht abstrakte Methode kann von jeder Subklasse genutzt werden
  public String pflanzen(){
      System.out.println("Ich werden gepflanzt");
  }
}

public class Rose extends Blume{
  // Implementierung der "duft()" Methode
  private String duft(){
    System.out.println("Rosen duften gut!");
  }
}
```

#### Interface
* `Interface` ist a blueprint (Bauplan) einer **class**.
* Beinhaltet nur Abstrakte Methoden

**Beispiel:**
```java
// Interface gibt die Methoden vor die Implementiert werden müssen
interface Papier{
    void drucken();
}

// Sub-Klasse implementiert die Vorgaben
public class A4 implements Papier{
    public void drucken(){
      System.out.println("Seite wird gedruckt");
    }
}
```