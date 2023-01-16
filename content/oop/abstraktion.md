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

{{%expand "Was ist der Unterschied zwischen einer Abstract Class und einem Interface in Java" %}}

In Java gibt es zwei Arten von abstrakten Typen: abstrakte Klassen und Interfaces. Der Unterschied besteht darin, dass:
* Eine abstrakte Klasse Methoden und Felder enthalten kann, die bereits implementiert sind. Sie kann auch nicht-abstrakte Methoden enthalten. Eine abstrakte Klasse kann nicht instantiiert werden, aber sie kann von einer anderen Klasse erweitert werden.
* Ein Interface enthält nur Methodensignaturen und keine Implementierungen. Es kann keine Felder enthalten. Ein Interface kann von einer Klasse implementiert werden, aber es kann nicht erweitert werden.
Ein anderer Unterschied ist, dass eine Klasse nur von einer abstrakten Klasse erben kann, aber mehrere Interfaces implementieren kann.

{{% /expand%}}

{{%expand "wann erkenne ich wann ich was verwenden soll? gibt es eine Eselsbrücke dafür?" %}}


Es gibt keine feste Regel dafür, wann man eine abstrakte Klasse oder ein Interface verwenden sollte. Es hängt von der spezifischen Anforderung Ihres Projekts und der Art der Beziehungen zwischen den Klassen ab. Eine allgemeine Empfehlung ist jedoch:
* Verwenden Sie eine abstrakte Klasse, wenn Sie eine gemeinsame Basisklasse für mehrere Klassen haben, die bereits implementierte Methoden oder Felder enthält.
* Verwenden Sie ein Interface, wenn Sie sicherstellen möchten, dass bestimmte Methoden von bestimmten Klassen implementiert werden, ohne dass diese Klassen von einer gemeinsamen Basisklasse erben.
Eine Eselsbrücke die man sich merken kann, um sich daran zu erinnern, wann man welches verwenden sollte:
* "abstrakt" für Abstraktion (gemeinsame Basis)
* "interface" für Implementierung (Verpflichtung zur Implementierung von Methoden)
Es ist auch wichtig zu beachten, dass ab Java 8 Interfaces auch default Methoden haben können und somit auch bereits implementierte Methoden enthalten können.


{{% /expand%}}

{{%expand "Du redest von nicht-abstrakten Methoden - was ist eine abstrakte Methode?" %}}


Eine abstrakte Methode ist eine Methode, die in einer abstrakten Klasse oder einem Interface definiert wird, aber keine Implementierung hat. Sie hat nur eine Signatur, die beschreibt, welche Argumente die Methode erwartet und welchen Rückgabetyp sie hat. Eine abstrakte Methode muss in jeder nicht-abstrakten Unterklasse implementiert werden, die von der abstrakten Klasse erbt oder das Interface implementiert.
Ein Beispiel für eine abstrakte Methode in Java wäre:

```java
abstract class Shape {
    abstract double getArea();
}
```

In diesem Beispiel enthält die abstrakte Klasse Shape eine abstrakte Methode mit dem Namen "getArea", die keine Implementierung hat. Jede nicht-abstrakte Unterklasse von Shape, wie z.B. Rectangle oder Circle, muss eine Implementierung für die Methode "getArea" bereitstellen.
Es ist wichtig zu beachten, dass eine abstrakte Klasse mindestens eine abstrakte Methode enthalten muss, um als abstrakte Klasse zu gelten. Eine Klasse, die keine abstrakte Methode enthält, kann nicht als abstrakte Klasse deklariert werden.


{{% /expand%}}

{{%expand "kann ein Interface instanziiert werden?" %}}


Nein, ein Interface kann nicht instanziiert werden. Ein Interface ist ein abstrakter Typ, der nur Methodensignaturen enthält, aber keine Implementierungen. Es kann keine Objekte von einem Interface erstellt werden, da es keine konkrete Implementierung der Methoden hat.
Eine Klasse, die ein Interface implementiert, muss die Methoden des Interfaces implementieren und kann dann instanziiert werden. Es gibt jedoch seit Java 8 die Möglichkeit, das Interface zu implementieren und zusätzlich einen default Methodenkörper zu haben, so dass man auf diesen Methoden aufrufen kann ohne das die Klasse selbst eine Implementierung besitzt.
Ein Beispiel:

```java
interface MyInterface {
    void myMethod();
    default void myMethod2(){
    System.out.println("default implementation");
    }
}
class MyClass implements MyInterface {
    public void myMethod() {
        // Implementation
    }
}
MyClass myObject = new MyClass();
myObject.myMethod();
myObject.myMethod2();
```

In diesem Beispiel kann man sehen, dass die Klasse MyClass das Interface MyInterface implementiert und dadurch die Methode myMethod() implementieren muss. myMethod2() kann aber ohne Implementierung in MyClass aufgerufen werden, da es einen default Methodenkörper besitzt.

￼
{{% /expand%}}

{{%expand "dann können folglich weder Interfaces, noch abstrakte Klassen instanziiert werden, oder?" %}}


Das ist richtig, weder Interfaces noch abstrakte Klassen können direkt instanziiert werden.
Eine abstrakte Klasse ist ein abstrakter Typ, der bereits implementierte Methoden und Felder enthalten kann, aber auch abstrakte Methoden besitzen kann. Da eine abstrakte Klasse nicht vollständig implementiert ist, kann sie nicht als Objekt verwendet werden. Eine nicht-abstrakte Unterklasse muss erstellt werden, die die abstrakten Methoden der abstrakten Klasse implementiert, bevor ein Objekt erstellt werden kann.
Ein Interface ist ein abstrakter Typ, der nur Methodensignaturen enthält, aber keine Implementierungen. Eine Klasse, die ein Interface implementiert, muss die Methoden des Interfaces implementieren und kann dann instanziiert werden. Ein Interface selbst kann jedoch nicht instanziiert werden, da es keine Implementierungen der Methoden hat.
Es ist auch wichtig zu beachten, dass ab Java 8 Interfaces auch default Methoden haben können. Diese Methoden besitzen bereits eine Implementierung, jedoch ist es nicht möglich ein Interface als Objekt zu instanzieren.

￼
{{% /expand%}}

{{%expand "welche Konstellationen sind möglich - da war doch noch etwas in etwa "eine abstrakte Klasse/Interface kann nicht von einem solchen selbigen erben", oder?" %}}


Ja, das ist richtig. Eine abstrakte Klasse kann nicht von einer anderen abstrakten Klasse erben und ein Interface kann nicht von einem anderen Interface erben. Eine abstrakte Klasse kann jedoch von einem Interface erben und eine Klasse kann sowohl von einer abstrakten Klasse als auch von mehreren Interfaces erben.
Hier sind einige mögliche Konstellationen:
* Eine nicht-abstrakte Klasse kann von einer abstrakten Klasse erben und dabei die abstrakten Methoden der abstrakten Klasse implementieren.
* Eine nicht-abstrakte Klasse kann mehrere Interfaces implementieren und dabei die Methoden aller implementierten Interfaces implementieren.
* Eine abstrakte Klasse kann von einem Interface erben und dabei die Methoden des Interfaces implementieren.
* Eine nicht-abstrakte Klasse kann sowohl von einer abstrakten Klasse als auch von mehreren Interfaces erben und dabei die Methoden beider Typen implementieren.
Es ist wichtig zu beachten, dass eine Klasse nur von einer einzigen Klasse erben kann, aber mehrere Interfaces implementieren kann.
Es ist auch wichtig zu beachten, dass seit Java 8 Interfaces auch default Methoden enthalten können, so dass man diese Methoden aufrufen kann ohne das die Klasse selbst eine Implementierung besitzt.
Es gibt auch die Möglichkeit, dass eine abstrakte Klasse mehrere Interfaces implementiert, in diesem Fall muss die abstrakte Klasse die Methoden aus allen implementierten Interfaces implementieren oder sie als abstrakt deklarieren.

￼
{{% /expand%}}

{{%expand "wie könnte eine nicht-abstrakte Methode aussehen, welche von einer abstrakten Klasse und mehreren Interfaces erbt?" %}}


Wenn eine nicht-abstrakte Klasse von einer abstrakten Klasse und mehreren Interfaces erbt, muss sie die Methoden der abstrakten Klasse und der Interfaces implementieren. Eine nicht-abstrakte Methode, die von einer abstrakten Klasse und mehreren Interfaces erbt, könnte in etwa so aussehen:

```java
interface Interface1 {
    void interfaceMethod1();
}

interface Interface2 {
    void interfaceMethod2();
}

abstract class AbstractClass {
    abstract void abstractMethod();
}

class ConcreteClass extends AbstractClass implements Interface1, Interface2 {
    public void abstractMethod() {
        // Implementation
    }

    public void interfaceMethod1() {
        // Implementation
    }

    public void interfaceMethod2() {
        // Implementation
    }
}
```

In diesem Beispiel erbt die Klasse ConcreteClass von der abstrakten Klasse AbstractClass und implementiert die Interfaces Interface1 und Interface2. Daher muss die Klasse ConcreteClass die Methoden abstractMethod, interfaceMethod1 und interfaceMethod2 implementieren.
Es ist auch wichtig zu beachten, dass in diesem Beispiel, falls in eines der Interfaces default Methoden vorhanden sind, die Klasse ConcreteClass diese nicht implementieren muss. Sie kann diese Methoden direkt aufrufen und verwenden.

￼
{{% /expand%}}

{{%expand "Und mit "default-Methoden" meist du solche Methoden, welche nicht nur Methodensignaturen, sondern auch Implementierungen sind, oder?" %}}


Ja, das ist korrekt. "Default-Methoden" sind Methoden in Interfaces, die nicht nur Methodensignaturen, sondern auch eine Implementierung besitzen. Diese Methoden können direkt aufgerufen werden, ohne dass die implementierende Klasse eine eigene Implementierung bereitstellen muss.
Seit Java 8 gibt es die Möglichkeit, default Methoden in Interfaces zu definieren. Diese Methoden werden mit dem Schlüsselwort "default" gekennzeichnet und haben einen Methodenkörper wie eine normale Methode. Diese default Methoden ermöglichen es, dass Interfaces bereits eine Implementierung besitzen und somit eine bestimmte Funktionalität bereitstellen können, ohne dass die implementierende Klasse diese selbst implementieren muss.
Wenn eine Klasse ein Interface implementiert, das default Methoden enthält, kann sie diese Methoden direkt verwenden, ohne sie zu implementieren. Wenn die Klasse jedoch eine eigene Implementierung für eine default Methode bereitstellen möchte, kann sie dies tun, indem sie die default Methode mit dem Schlüsselwort "override" überschreibt.
Es ist auch wichtig zu beachten, dass eine abstrakte Klasse, die ein Interface implementiert, die default Methoden des Interfaces entweder implementieren oder als abstrakt deklarieren muss.

￼
{{% /expand%}}

{{%expand "hast du für letzteres ein Beispiel?" %}}


Gerne. Hier ist ein Beispiel, in dem eine abstrakte Klasse ein Interface implementiert, das default Methoden enthält:

```java
interface MyInterface {
    void myMethod();
    default void myDefaultMethod() {
        System.out.println("default implementation");
    }
}

abstract class MyAbstractClass implements MyInterface {
    public abstract void myMethod();
    public void myDefaultMethod(){
        //here the abstract class is providing an implementation for the default method
    }
}

class MyConcreteClass extends MyAbstractClass {
    public void myMethod() {
        // Implementation
    }
}
```

In diesem Beispiel implementiert die abstrakte Klasse MyAbstractClass das Interface MyInterface, das die default Methode myDefaultMethod() enthält. Da die abstrakte Klasse MyAbstractClass das Interface implementiert, muss sie die Methoden des Interfaces implementieren. In diesem Fall hat MyAbstractClass die default Methode myDefaultMethod implementiert und kann somit direkt aufgerufen werden.
Es ist auch wichtig zu beachten, dass die nicht-abstrakte Unterklasse MyConcreteClass, die von MyAbstractClass erbt, die default Methode myDefaultMethod() nicht implementieren muss, da sie bereits von der abstrakten Klasse implementiert wurde.
Es gibt auch die Möglichkeit, dass die abstrakte Klasse die default Methode als abstrakt deklariert und somit die nicht-abstrakte Unterklasse die Methode implementieren muss.
Es gibt also mehrere Möglichkeiten, wie eine abstrakte Klasse mit default Methoden in Interfaces umgehen kann.

{{% /expand%}}