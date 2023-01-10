package vorlesung.rational;


/**
 * Eine Rationale Zahl ist reelle Zahl, die als Verhältnis (lateinisch ratio)
 * zweier ganzer Zahlen dargestellt werden kann.
 * <p>
 * Diese Klasse repräsentiert UNVERÄNDERLICHE Brüche mit Zähler und Nenner.
 * Die Werte von Zähler und Nenner sind unabhängig vom initialen Wert immer gekürzt.
 *
 * @author Ulrike Hammerschall
 */
public class ImmutableRational {

    /**
     * Unveränderliche Objektvariable für Zähler.
     */
    private final int num;

    /**
     * Unveränderliche Objektvariable für Nenner.
     */
    private final int denom;

    /**
     * Klassenvariable: Zähler für initialisierte Objekte zur Klasse.
     */
    private static int counter = 0;


    /**
     * Custom-Konstruktor zum Setzen von Zähler und Nenner.
     *
     * @param num   Zähler des Bruchs
     * @param denom Nenner des Bruchs (darf nicht 0 sein)
     * @throws IllegalArgumentException falls der Nenner 0 ist
     */
    public ImmutableRational(int num, int denom) {
        if (denom == 0) {
            // Kleiner Ausblick zur Fehlerbehandlung
            throw new IllegalArgumentException();
        }
        int ggt = ggt(num, denom);
        this.num = num / ggt;
        this.denom = denom / ggt;
        counter++;
    }

    /**
     * Custom-Konstruktor mit Constructor-Chaining.
     *
     * @param num Zähler des Bruchs, der Nenner wird immer auf 2 gesetzt.
     */
    public ImmutableRational(int num) {
        this(num, 2);
    }

    /**
     * Default-Konstruktor mit Constructor-Chaining.
     * Der Bruch wird immer auf 1/2 gesetzt.
     */
    public ImmutableRational() {
        this(1);
    }

    /**
     * Copy-Konstruktor mit Constructor-Chaining.
     *
     * @param orig Objekt von dem eine Kopie erstellt werden soll
     */
    public ImmutableRational(ImmutableRational orig) {
        this(orig.getNum(), orig.getDenom());
    }

    /**
     * Klassenmethode: Getter für Counter.
     *
     * @return aktuellen Wert des Counters
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * Getter für den Zähler.
     *
     * @return Wert des Zählers
     */
    public int getNum() {
        return num;
    }

    /**
     * Getter für Nenner.
     *
     * @return Wert des Nenners
     */
    public int getDenom() {
        return denom;
    }

    @Override
    public String toString() {
        return getNum() + " / " + getDenom();
    }

    /**
     * Berechnung des größten gemeinsamen Teilers zweier Werte.
     *
     * @param a Erster Wert
     * @param b Zweiter Wert
     * @return Größter gemeinsamer Teiler der beiden Werte
     */
    private int ggt(int a, int b) {
        int a1 = Math.abs(a);
        int b1 = Math.abs(b);
        while (a1 != b1) {
            if (a1 > b1) {
                a1 = a1 - b1;
            } else {
                b1 = b1 - a1;
            }
        }
        return a1;
    }
	
	public static void main(String[] args) {

        ImmutableRational rat1 = new ImmutableRational(3, 4);
        ImmutableRational rat2 = new ImmutableRational(18, 6);
        ImmutableRational rat3 = new ImmutableRational(5, -6);
        ImmutableRational rat4 = new ImmutableRational(15, 66);

        System.out.println(ImmutableRational.getCounter());

    }

}





















