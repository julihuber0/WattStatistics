import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Double> crits = new ArrayList<>();

    private int crit2;
    public Game() {
    }

    public void initiate() {
        for (int i = 7; i <= 14; i++) {
            deck.add(new Card(Color.EICHEL, i));
            deck.add(new Card(Color.HERZ, i));
            deck.add(new Card(Color.SCHELLEN, i));
            deck.add(new Card(Color.GRAS, i));
        }
    }

    public void simulateGame() {
        Collections.shuffle(deck);
        crit2 = 0;
        //System.out.println("Deckgröße: "+deck.size());
        //for(int i = 0; i<32; i++){
            //System.out.println(i+": "+deck.get(i).getValue()+" in "+deck.get(i).getColor());
        //}
        int critCount = 0;
        for (int i = 0; i < 21; i++) {
            if (checkCrit(i)) {
                critCount++;
                crit2 = 1;
            }
        }
        for (int i = 21; i < 24; i++) {
            if (!checkCrit(i)) {
                break;
            }
        }
        crits.add((double) critCount);
    }

    public boolean checkCrit(int value) {
        if (deck.get(value).getValue() == 7) {
            if (deck.get(value).getColor() == Color.EICHEL || deck.get(value).getColor() == Color.SCHELLEN) {
                if(deck.get(value).getColor() == Color.EICHEL) {
                    //System.out.println("Da Spitz wurde gefunden.");
                } else {
                    //System.out.println("Da Welle wurde gefunden.");
                }
                return true;
            }
        }
        if (deck.get(value).getValue() == 13) {
            if (deck.get(value).getColor() == Color.HERZ) {
                //System.out.println("Da Max wurde gefunden.");
                return true;
            }
        }
        return false;
    }

    public ArrayList<Double> getCrits() {
        return crits;
    }

    public int getCrit2() {
        return crit2;
    }
}