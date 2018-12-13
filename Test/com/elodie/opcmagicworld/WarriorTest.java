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

}