---
title: "Zugriffsbeschränkungen"
weight: 90
---

* default (No keyword required)
* `private`
* `public`
* `protected`

{{% notice note %}}
Die Standard-Sichtbarkeit ist "package-private" (obwohl diese nicht explizit verwendet werden kann), was bedeutet, dass das Feld innerhalb desselben Pakets, zu dem die Klasse gehört, zugänglich ist.
Dies gilt jedoch nicht für Schnittstellenmitglieder, für die der Standardwert "public" ist.
{{% /notice %}}

### NON ACCESS MODIFIERS

* `static`
* `final`
* `transient`
* `abstract`
* `synchronized`
* `volatile`