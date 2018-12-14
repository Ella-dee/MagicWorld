package com.elodie.opcmagicworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoutTest extends PlayerTest {


    /**
     * description()
     */
    @Test
    void Given_ScoutClass_ThenPrintsScoutDescription() {
        Player player1 = new Scout("Test Player", 3, 15, 10, 2, 2);
        String expectedResult = "*apparait par derrière en toute discrétion* Je suis un Rôdeur de niveau 3 avec 15 points de vie. J'ai une force de 10, agilité de 2, et une intélligence de 2.";
        String result = player1.description();
        assertEquals(expectedResult, result);
    }

    /**
     * attackBasic()
     */
    @Test
    void GivenBasicAttack_ScoutAgility_EqualsDamages() {
        Player player1 = new Scout("Test Player", 3, 15, 10, 2, 2);
        int expectedResult = 2;
        int result = player1.getpAgility();
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player utilise tir à l'arc et inflige 2 dommages";
        String stringResult = player1.getpName()+" utilise "+player1.getBasicAttack()+" et inflige "+result+" dommages";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    void GivenBasicAttack_2Damages_Player2Loses2HealthPoints() {
        Player player1 = new Scout("Test Player", 3, 15, 10, 2, 10);
        Player player2 = new Scout("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpAgility();
        int expectedResult = 13;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player2 perd 2 points de vie.";
        String stringResult = player2.getpName()+" perd "+ damages+ " points de vie.";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    void GivenBasicAttack_LostHealthPointsBasicAttack_PlayerHealthPointsUpDates() {
        Player player1 = new Scout("Test Player", 3, 5, 10, 2, 10);
        Player player2 = new Scout("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpAgility();
        player2.setpHP(player2.getpHP() - damages);
        int expectedResult = 13;
        int result = player2.getpHP();
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenBasicAttack_PrintsAllStrings() {
        Player player1 = new Scout("Test Player", 3, 5, 20, 2, 10);
        Player player2 = new Scout("Test Player2", 3, 15, 2, 2, 55);
        player1.attackBasic(player2);
        String expectedStringResult = "Test Player utilise tir à l'arc et inflige 2 dommages\nTest Player2 perd 2 points de vie.\n";
        String stringResult = player1.getpName()+" utilise "+player1.getBasicAttack()+" et inflige "+player1.getpAgility()+" dommages\n"+player2.getpName()+" perd "+player1.getpAgility()+" points de vie.\n";
        assertEquals(expectedStringResult, stringResult);
    }

    /**
     * attackSpecial()
     */
    @Test
    void Given_Concentration_ItEqualsScoutLevelDividedBy2() {
        Player player1 = new Scout("Test Player", 4, 5, 10, 2, 2);
        int expectedResult = 2;
        int result = player1.getpLevel() / 2;
        assertEquals(expectedResult, result);
    }
    @Test
    void Given_Concentration_ScoutsAgilityUpdatesToInitialAgilityPlusScoutLevelDividedBy2(){
        Player player1 = new Scout("Test Player", 4, 20, 10, 2, 2);
        player1.attackSpecial(player1);
        int expectedResult = 4;
        int result = player1.getpAgility();
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_PrintsAllStrings(){
        Player player1 = new Scout("Test Player", 4, 20, 10, 2, 10);
        String stringExpectedResult = "Test Player utilise concentration et gagne 2 points en agilité";
        String stringResult = player1.getpName()+" utilise "+player1.getSpecialAttack()+" et gagne "+player1.getpLevel() / 2+" points en agilité";
        assertEquals(stringExpectedResult, stringResult);
    }

}