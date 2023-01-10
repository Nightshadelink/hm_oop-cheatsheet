---
title: "Programmfluss und Kontrollstrukturen"
weight: 70
---

### Kontrollstruktur
> IF Statement
```java
// Wenn x größer als y ist, dann...
if (x > y) {
  // ...führe den Code in dem Block aus
}
```

> IF-ELSE STATEMENT
```java
// Wenn x größer als y ist, dann...
if (x > y) {
  // ...führe den Code in dem Block aus
}else{
  // ... sonst führe diesen Block aus
}
```

> Verschachtelte Bedingungen
```java
// Wenn x größer als y ist, dann...
if (x > y) {
  // ...führe den Code in dem Block aus

// wenn x gleich y ist...
}else if(x == y){
  // .. führe diesen Block aus
}else{
  // ... sonst führe diesen Block aus
}
```

> SWITCH STATEMENT
```java
switch (VARIABLE-ZUM-AUSWERTEN) {
  case value:
    Statement;
    break;
  ...
  ...
  ...
  default:
    Statement;
    break;
}
```

#### ANATOMY OF A LOOP  STATEMENT
> FOR LOOP STATEMENT
```java
for (zaehlvariable; Abbruchbedingung; Schrittweite){
  // Code
}
```
**Beispiel:**

_Zähle von 0 bis 10 in Einer-Schritten und gib die Zahl auf der Konsole aus_:

```java
for (int i = 0; i <= 10; i++) {
    System.out.println(i);
}
```

> FOR-EACH STATEMENT
```java
for(dataType item : array) {
    // code
}
```
**Beispiel:**

_gib alle Elemente aus dem Array numbers aus_

```java
// array of numbers
int[] numbers = {100, 200, 300, 400};

// for each loop
for (int number: numbers) {
  System.out.println(number);
}
```

> WHILE LOOP STATEMENT
```java
while(Abbruchbedingung){
  // code
}
```
**Beispiel:**

_Zähle von 0 bis 10 in Einer-Schritten und gib die Zahl auf der Konsole aus_:

```java
// Zählvariable
int i = 0;

while (i <= 10){
  System.out.println(i);
  i++;    // i = i +1 ;
}
```

> DO-WHILE LOOP STATEMENT

Fußgesteuert -> der Block wird immer mind. einmal ausgeführt.

```java
do{
  // code
} while(Abbruchbedingung);
```

**Beispiel:**

_Zähle von 0 bis 10 in Einer-Schritten und gib die Zahl auf der Konsole aus_:

```java
int i = 0;
do{
  System.out.println(i);
  i++;
} while(i <= 10);
```