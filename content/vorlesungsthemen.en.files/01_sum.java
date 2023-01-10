/**
 * Berechnet die Summe aller Zahlen von 1 bis zu einer Obergrenze n.
 *
 * @author Ulrike Hammerschall
 */
class Sum {

    public static void main(String[] args) {

        // Einlesen der Obergrenze von der Kommandozeile
        int boundary = Integer.parseInt(args[0]);

        // Variable für das Endergebnis
        int sum = 0;

        // Berechnung der Summe mit for-Schleife
        for (int i = 1; i <= boundary; i++) {
            sum += i;
        }

        // Ausgabe des Ergebnisses
        System.out.println(sum);
    }
}
