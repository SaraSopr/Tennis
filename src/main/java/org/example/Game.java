package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
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

    public void giocatoreFaPunto(Player giocatore) {
        Player giocatore2 = rilevaAltroGiocatore(giocatore);
        if(this.deuce){
            situazioneDiGiocoDeuce(giocatore, giocatore2);
        }
        else situazioneDiGiocoNormale(giocatore);

    }

    private void situazioneDiGiocoDeuce(Player giocatore, Player giocatore2) {
        if(giocatore.advantage && !giocatore2.advantage)
            this.vincita = true;
        else {
            giocatore.advantage = false;
            giocatore2.advantage = false;
        }
    }

    private void situazioneDiGiocoNormale(Player giocatore) {
        int index_ultimo_punto = points.indexOf(giocatore.point);
        if (index_ultimo_punto != points.size()-1){
            giocatore.point = points.get(index_ultimo_punto +1);
            this.vincita = false;
        } else {
            this.vincita = true;
        }
    }

    private Player rilevaAltroGiocatore(Player giocatore) {
        if(giocatore.hashCode()==this.giocatore1.hashCode())
            return this.giocatore2;
        else return this.giocatore1;
    }


    public void isInDeuce(String point_p1, String point_p2) {
        if (point_p1 == point_p2 && point_p1 == "40")
            this.deuce = true;

    }
}
