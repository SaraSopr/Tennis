package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    static final ArrayList<String> points = new ArrayList<>(Arrays.asList("Love", "15", "30", "40"));

    Player giocatore1;
    Player giocatore2;

    boolean deuce = false;
    boolean vincita = false;

    public Game(Player giocatore1, Player giocatore2) {
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
    }

    public static boolean giocatoreFaPunto(Player giocatore) {
        int index_ultimo_punto = points.indexOf(giocatore.point);
        if (index_ultimo_punto != points.size()-1){
            giocatore.point = points.get(index_ultimo_punto+1);
            return false;
        }
        else{
            return true;
        }
    }

    public void isInDeuce(String point_p1, String point_p2) {
        if (point_p1 == point_p2 && point_p1 == "40")
            this.deuce = true;

    }
}
