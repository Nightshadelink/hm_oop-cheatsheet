---
title: "Methoden"
---

* Code wiederverwenden statt neuschreiben
* Testbarkeit erhöhen
* Lesbarkeit verbessern

> Allgemein
```
<Sichtbarkeit> <Rückgabewert> <Methodenname>(<Parameter>){
  // Code
}
```

**Beispiel:**
```java
// addition zweier Zahlen a und b
public int sum (int a, int b) {
  // lokale variable
  int result;

  // Berechnung
  result = a + b;

  // Ergebnis zurückgeben
  return result;
}
```

Vereinfacht:

```java
// addition zweier Zahlen a und b
public int sum (int a, int b) {
  // Ergebnis direkt zurückgeben
  return (a + b);
}
```