public class GameOfLife {
    //Main
    public static void main(String[] args) {
        Spielfeld spielBeginn = new Spielfeld(100, 100);
        spielBeginn.zeichnen();
    }


    //Nachbarn zählen
    public int zählNachbarn(int[][] spielFeld, int zeilen, int spalte, int aktZeile, int aktSpalte) {

        int anzahlNachbarn = 0;

        if () {

        }
        return anzahlNachbarn;
    }

    //nächste Generation erzeugen
    public int[][] nextGen(int[][] currGen, int zeilen, int spalten) {

        //Tote Zelle, 3 Nachbarn, Wiedergeburt
        if (i = 0 && anzahlNachbarn = 3) {
            i == 1;
        }
        //Lebende Zelle, weniger als 2 Nachbarn, Tod
        if (i = 1 && anzahlNachbarn < 2) {
            i == 0;
        }
        //Lebende Zelle, 2 oder 3 Nachbarn, lebend
        if (i = 1 && anzahlNachbarn = 2 || anzahlNachbarn = 3) {
            i == 1;
        }
        //Lebende Zelle, mehr als 2 Nachbarn, Tod
        if (i = 1 && anzahlNachbarn > 3) {
            i == 0;
        }

        return nextGen;
    }

}