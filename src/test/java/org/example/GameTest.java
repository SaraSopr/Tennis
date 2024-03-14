package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void vinciGame_unoDeiDueGiocatorifaPuntoDopo40_VinceIlGame(){
        Player giocatore = new Player("40");
        boolean vinto = Game.giocatoreFaPunto(giocatore);
        assertThat(vinto).isEqualTo(true);
    }

    @Test
    void continuaGame_unoDeiDueGiocatorifaPuntoDopo30_AumentaIlPunteggioA40(){
        Player giocatore = new Player("30");
        boolean vinto = Game.giocatoreFaPunto(giocatore);
        assertThat(giocatore.point).isEqualTo("40");
    }

    @Test
    void game_entrambiIGiocatoriSonoA40Punti_GameInDeuce(){
        Player giocatore1 = new Player("40");
        Player giocatore2 = new Player("40");
        Game game = new Game(giocatore1, giocatore2);
        game.isInDeuce(giocatore1.point, giocatore2.point);
        assertThat(game.deuce).isEqualTo(true);
    }

    @Test
    void game_soloUnGiocatoreA40Punti_GameNonInDeuce(){
        Player giocatore1 = new Player("40");
        Player giocatore2 = new Player("30");
        Game game = new Game(giocatore1, giocatore2);
        game.isInDeuce(giocatore1.point, giocatore2.point);
        assertThat(game.deuce).isEqualTo(false);
    }

}