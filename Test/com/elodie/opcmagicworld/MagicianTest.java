package com.elodie.opcmagicworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicianTest extends PlayerTest {
    /**
     * getcClass()
     */
    @Test
    void Given_MagicianClass_PrintsMagicianClass() {
        Player player1 = new Magician("Test Player", 3, 5, 10, 2, 2);
        String expectedResult = "Je suis un Magicien ";
        String result = player1.getcClass();
        assertEquals(expectedResult, result);
    }
    /**
     * getcIntro()
     */
    @Test
    void Given_MagicianClass_PrintsMagicianIntro() {
        Player player1 = new Magician("Test Player", 3, 5, 10, 2, 2);
        String expectedResult = "Expecto Patronum!!!!! ";
        String result = player1.getcIntro();
        assertEquals(expectedResult, result);
    }

    /**
     * description()
     */
    @Test
    void Given_MagicianClass_ThenPrintsMagicianDescription() {
        Player player1 = new Magician("Test Player", 3, 15, 10, 2, 2);
        String expectedResult = "Expecto Patronum!!!!! Je suis un Magicien de niveau 3 avec 15 points de vie. J'ai une force de 10, agilité de 2, et une intélligence de 2.";
        String result = player1.description();
        assertEquals(expectedResult, result);
    }

    /**
     * attackBasic()
     */
    @Test
    void GivenBasicAttack_MagicianIntel_EqualsDamages() {
        Player player1 = new Magician("Test Player", 3, 15, 10, 2, 2);
        int damages = player1.getpIntel();
        int expectedResult = 2;
        int result = damages;
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player utilise boule de feu et inflige 2 dommages";
        String stringResult = player1.getpName()+" utilise "+player1.getBasicAttack()+" et inflige "+damages+" dommages";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    void GivenBasicAttack_10Damages_Player2Loses10HealthPoints() {
        Player player1 = new Magician("Test Player", 3, 15, 10, 2, 10);
        Player player2 = new Magician("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpIntel();
        int expectedResult = 5;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player2 perd 10 points de vie.";
        String stringResult = player2.getpName()+" perd "+ damages+ " points de vie.";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    void GivenBasicAttack_LostHealthPointsBasicAttack_PlayerHealthPointsUpDates() {
        Player player1 = new Magician("Test Player", 3, 5, 10, 2, 10);
        Player player2 = new Magician("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpIntel();
        player2.setpHP(player2.getpHP() - damages);
        int expectedResult = 5;
        int result = player2.getpHP();
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenBasicAttack_PrintsAllStrings() {
        Player player1 = new Magician("Test Player", 3, 5, 20, 2, 10);
        Player player2 = new Magician("Test Player2", 3, 15, 2, 2, 55);
        player1.attackBasic(player2);
        String expectedStringResult = "Test Player utilise boule de feu et inflige 10 dommages\nTest Player2 perd 10 points de vie.\n";
        String stringResult = player1.getpName()+" utilise "+player1.getBasicAttack()+" et inflige "+player1.getpIntel()+" dommages\n"+player2.getpName()+" perd "+player1.getpIntel()+" points de vie.\n";
        assertEquals(expectedStringResult, stringResult);
    }

    /**
     * attackSpecial()
     */

    @Test
    void GivenSpecialAttack_Soin_MagicianMakesCureForTwiceItsIntel() {
        Player player1 = new Magician("Test Player", 4, 5, 10, 2, 2);
        int cure = player1.getpIntel()*2;
        int expectedResult = 4;
        int result = cure;
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_Soin_MagicianAppliesCureAndGainsHealthPoints_MaxedOutToInitialHealthPoints() {
        Player player1 = new Magician("Test Player", 2, 10, 10, 2, 10);
        player1.setpHP(5);
        ((Magician) player1).checkCure();
        int expectedResult = 5;
        int result = ((Magician) player1).checkCure();
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_Soin_PlayerHealthPointsUpDates() {
        Player player1 = new Magician("Test Player", 2, 10, 10, 2, 10);
        player1.setpHP(5);
        ((Magician) player1).attackSpecial(player1);
        int expectedResult = 10;
        int result = player1.getpHP();
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_PrintsAllStrings(){
        Player player1 = new Magician("Test Player", 2, 10, 10, 2, 10);
        player1.setpHP(5);
        String stringExpectedResult = "Test Player utilise soin et gagne 5 points de vie";
        String stringResult = player1.getpName()+" utilise "+player1.getSpecialAttack()+" et gagne "+((Magician) player1).checkCure()+" points de vie";
        assertEquals(stringExpectedResult, stringResult);
    }
}