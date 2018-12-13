package com.elodie.opcmagicworld;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void Given_GetPlayerStats_GettersReturnStats() {
        Player player = new Player("Test", 5, 25, 6, 1, 6);
        String expectedResult = "name Test, level 5, hp 25, strength 6, dex 1, intel 6";
        String result = "name " + player.getpName() + ", level " + player.getpLevel() + ", hp " + player.getpHP() + ", strength " + player.getpStrength() + ", dex " + player.getpAgility() + ", intel " + player.getpIntel();
        assertEquals(expectedResult, result);
    }

    @Test
    void Given_SetPlayerStats_SettersUpdateStats() {
        Player player = new Player("", 0, 0, 0, 0, 0);
        player.setpName("Test");
        player.setpLevel(5);
        player.setpHP(10);
        player.setpStrength(6);
        player.setpAgility(1);
        player.setpIntel(6);
        String expectedResult = "name Test, level 5, hp 10, strength 6, dex 1, intel 6";
        String result = "name " + player.getpName() + ", level " + player.getpLevel() + ", hp " + player.getpHP() + ", strength " + player.getpStrength() + ", dex " + player.getpAgility() + ", intel " + player.getpIntel();
        assertEquals(expectedResult, result);
    }
}