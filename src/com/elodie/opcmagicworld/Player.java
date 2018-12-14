package com.elodie.opcmagicworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private String pName;
    private String cClass;
    private String cIntro;
    private int pLevel;
    private int pHP;
    private int pStrength;
    private int pAgility;
    private int pIntel;
    private String basicAttack;
    private String specialAttack;

    public Player(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        this.pName = pName;
        this.pLevel = pLevel;
        this.pHP = pLevel * 5;
        this.pStrength = pStrength;
        this.pAgility = pAgility;
        this.pIntel = pIntel;
    }
    /**
     * Getters and Setters
     **/
    public String getpName() { return pName; }
    public String getcClass(){ return cClass; }
    public String getcIntro() { return cIntro; }
    public int getpLevel() { return pLevel;  }
    public int getpHP() { return pHP;  }
    public int getpStrength() {return pStrength; }
    public int getpAgility() {return pAgility; }
    public int getpIntel() {return pIntel; }
    public String getBasicAttack() {return basicAttack; }
    public String getSpecialAttack() { return specialAttack; }
    public void setpName(String pName) { this.pName = pName;  }
    public void setcClass(String cClass) { this.cClass = cClass;  }
    public void setpLevel(int pLevel) { this.pLevel = pLevel; }
    public void setpHP(int pHP) {this.pHP = pHP; }
    public void setpStrength(int pStrength) {this.pStrength = pStrength; }
    public void setpAgility(int pAgility) {this.pAgility = pAgility; }
    public void setpIntel(int pIntel) {this.pIntel = pIntel;}
    public void setBasicAttack(String basicAttack) {this.basicAttack = basicAttack;    }
    public void setSpecialAttack(String specialAttack) {this.specialAttack = specialAttack; }
    /**************************************************/
    /**Actions
     /****************************************/
    public String description() {
        String phrase = "de niveau " + pLevel + " avec " + pHP + " points de vie. J'ai une force de " + pStrength + ", agilité de " + pAgility + ", et une intélligence de " + pIntel + ".";
        return phrase;
    }
    public void attack(Player player){
        int attackChoice = actionChoice();
        if (attackChoice == 1)attackBasic(player);
        else if (attackChoice == 2)attackSpecial(player);
    }
    public void attackBasic(Player player){ }
    public void attackSpecial(Player player){ }

    public int  actionChoice(){
        int attackChoice = 0;
        Scanner sc = new Scanner(System.in);
        String whichAttack = "Veuillez choisir une attaque valide: 1- attaque basique, 2- attaque spéciale:";
        do {
            try {
                System.out.println(pName + " (vitalité " + pHP + "), "+ whichAttack);
                attackChoice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(whichAttack);
                sc.next();
            } finally {
                if (attackChoice < 1 || attackChoice > 100) {
                    System.out.println(whichAttack);
                }
            }
        }
        while((attackChoice!=1) &&(attackChoice!=2));
        return attackChoice;
    }
}
