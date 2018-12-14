package com.elodie.opcmagicworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest extends PlayerTest {

    /**
     * getcClass()
     */
    @Test
    void Given_WarriorClass_PrintsWarriorClass() {
        Player player1 = new Warrior("Test Player", 3, 5, 10, 2, 2);
        String expectedResult = "Je suis un Guerrier ";
        String result = player1.getcClass();
        assertEquals(expectedResult, result);
    }
    /**
     * getcIntro()
     */
    @Test
    void Given_WarriorClass_PrintsWarriorIntro() {
        Player player1 = new Warrior("Test Player", 3, 5, 10, 2, 2);
        String expectedResult = "Beware!!!!!";
        String result = player1.getcIntro();
        assertEquals(expectedResult, result);
    }

    /**
     * description()
     */
    @Test
    void Given_WarriorClass_ThenPrintsWarriorDescription() {
        Player player1 = new Warrior("Test Player", 3, 15, 10, 2, 2);
        String expectedResult = "Beware!!!!!Je suis un Guerrier de niveau 3 avec 15 points de vie. J'ai une force de 10, agilité de 2, et une intélligence de 2.";
        String result = player1.description();
        assertEquals(expectedResult, result);
    }
    /**
     * attackBasic()
     */
    @Test
    void GivenBasicAttack_WarriorStrength_EqualsDamages() {
        Player player1 = new Warrior("Test Player", 3, 15, 10, 2, 2);
        int expectedResult = 10;
        int result =  player1.getpStrength();
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player utilise coup d'épée et inflige 10 dommages";
        String stringResult = player1.getpName()+" utilise "+player1.getBasicAttack()+" et inflige "+result+" dommages";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    void GivenBasicAttack_10Damages_Player2Loses10HealthPoints() {
        Player player1 = new Warrior("Test Player", 3, 15, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpStrength();
        int expectedResult = 5;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);

        String expectedStringResult = "Test Player2 perd 10 points de vie.";
        String stringResult = player2.getpName()+" perd "+ damages+ " points de vie.";
        assertEquals(expectedStringResult, stringResult);
    }
    @Test
    void GivenBasicAttack_LostHealthPointsBasicAttack_PlayerHealthPointsUpDates() {
        Player player1 = new Warrior("Test Player", 3, 5, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        int damages = player1.getpStrength();
        player2.setpHP(player2.getpHP() - damages);
        int expectedResult = 5;
        int result = player2.getpHP();
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenBasicAttack_PrintsAllStrings() {
        Player player1 = new Warrior("Test Player", 3, 5, 20, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        player1.attackBasic(player2);
        String expectedStringResult = "Test Player utilise coup d'épée et inflige 20 dommages\nTest Player2 perd 20 points de vie.\n";
        String stringResult = player1.getpName()+" utilise "+player1.getBasicAttack()+" et inflige "+player1.getpStrength()+" dommages\n"+player2.getpName()+" perd "+player1.getpStrength()+" points de vie.\n";
        assertEquals(expectedStringResult, stringResult);
    }

    /**
     * attackSpecial()
     */
    @Test
    void GivenSpecialAttack_CoupDeRage_DamagesEqualsWarriorStrengthMultiplies2() {
        Player player1 = new Warrior("Test Player", 4, 5, 10, 2, 2);
        int expectedResult = 20;
        int result = player1.getpStrength()*2;
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_20Damages_Player2Loses20HealthPoint() {
        Player player1 = new Warrior("Test Player", 4, 5, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 5, 25, 2, 2, 55);
        int damages = player1.getpStrength()*2;
        int expectedResult = 5;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_LostHealthPoints_PlayerHealthPointsUpDates() {
        Player player1 = new Warrior("Test Player", 4, 20, 10, 2, 2);
        Player player2 = new Warrior("Test Player2", 5, 25, 2, 2, 55);
        int damages = player1.getpStrength() * 2;
        int expectedResult = 5;
        int result = player2.getpHP() - damages;
        assertEquals(expectedResult, result);
    }

    @Test
    void GivenSpecialAttack_WarriorAttackBackfiresAndLosesHealthPoints_ByOwnStrengthDividedBy2() {
        Player player1 = new Warrior("Test Player", 4, 5, 10, 2, 2);
        int expectedResult = 5;
        int result = player1.getpStrength() / 2;
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_WarriorAttackBackfired_PlayerHealthPointsUpDates(){
        Player player1 = new Warrior("Test Player", 4, 20, 10, 2, 2);
        int backfire = player1.getpStrength() / 2;
        int expectedResult = 15;
        int result = player1.getpHP() - backfire;
        assertEquals(expectedResult, result);
    }
    @Test
    void GivenSpecialAttack_PrintsAllStrings() {
        Player player1 = new Warrior("Test Player", 50, 250, 20, 2, 2);
        Player player2 = new Warrior("Test Player2", 3, 15, 2, 2, 55);
        player1.attackSpecial(player2);
        String expectedStringResult = "Test Player utilise coup de rage et inflige 40 dommages\nTest Player2 perd 20 points de vie.\nTest Player perd 10 points de vie.\n";
        String stringResult = player1.getpName()+" utilise "+player1.getSpecialAttack()+" et inflige "+player1.getpStrength()*2+" dommages\n"+player2.getpName()+" perd "+player1.getpStrength()+" points de vie.\n"+player1.getpName()+" perd "+player1.getpStrength()/2+" points de vie.\n";
        assertEquals(expectedStringResult, stringResult);
    }
}