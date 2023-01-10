---
title: "Instanzvariablen"
---

* Instanzvariablen sind nur innerhalb der Klasse _sichtbar_
* mit Hilfe von _getter_ und _setter_ können diese abgerufen oder verändert werden
  * `setter` sind vom typ `void` und sollten als Argument den Datentyp der jeweiligen Instanzvariable haben
  * `getter` geben den Datentyp zurück der Instanzvariable und sollten keine Argumente haben
* durch den `this` Operator kann man auf die Instanzvariablen direkt zugreifen

**Beispiel: Einfache Klasse:**
```java
public class Fahrzeug {
  private String name;
}
```

**Beispiel Klasse mit getter und setter:**
```java
public class Fahrzeug {
  private String name;

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }
}
```