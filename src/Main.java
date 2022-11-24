import java.util.ArrayList;

public class Main {

    private static final int GAMES = 1000000;
    public static void main(String[] args) {
        Game g = new Game();
        g.initiate();
        int noCrits = 0;
        for(int i = 0; i<GAMES; i++){
            //System.out.println("Spiel "+(i+1)+":");
            g.simulateGame();
            if(g.getCrit2() == 0) {
                //System.out.println("Kein Kritischer wurde gefunden.");
                noCrits += 1;
            }
            //System.out.println("");
        }
        ArrayList<Double> cr = g.getCrits();
        double sum = 0;
        for(int i = 0; i<cr.size(); i++){
            sum = sum + cr.get(i);
        }
        //System.out.println("");
        System.out.println("Die Anzahl der Spiele ohne Kritischen beträgt "+noCrits);
        double rate = (double)noCrits/(double)GAMES;
        System.out.println("Das ist eine Rate von "+ rate);
        System.out.println("Der Durchschnitt an Kritischen beträgt "+sum/cr.size());
    }
}
