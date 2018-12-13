package com.elodie.opcmagicworld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void Given_PlayerHPGetsToZero_GameStops(){
        Warrior player1 = new Warrior("Test Player", 3, 5, 2, 2, 2);
        Magician player2 = new Magician("Test Player2", 88, 44, 2, 2, 55);
        player2.attackBasic(player1);
        String expectedResult = "GAME OVER!";
        String result = Game.stop();
        assertEquals(expectedResult, result);
    }

}