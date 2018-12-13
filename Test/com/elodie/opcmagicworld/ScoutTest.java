package com.elodie.opcmagicworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoutTest extends PlayerTest {
    /**
     * getcClass()
     */
    @Test
    void Given_ScoutClass_PrintsScoutClass() {
        Player player1 = new Scout("Test Player", 3, 5, 10, 2, 2);
        String expectedResult = "Je suis un Rôdeur ";
        String result = player1.getcClass();
        assertEquals(expectedResult, result);
    }
    /**
     * getcIntro()
     */
    @Test
    void Given_ScoutClass_PrintsScoutIntro() {
        Player player1 = new Scout("Test Player", 3, 5, 10, 2, 2);
        String expectedResult = "*apparait par derrière en toute discrétion* ";
        String result = player1.getcIntro();
        assertEquals(expectedResult, result);
    }

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


}