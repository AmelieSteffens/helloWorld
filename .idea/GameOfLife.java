public class GameOfLife {

    public static void main(String[] args) {


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
    }
}