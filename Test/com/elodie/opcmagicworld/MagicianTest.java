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
}