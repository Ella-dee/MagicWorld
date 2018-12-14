package com.elodie.opcmagicworld;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * <b>Player est la classe mère des différentes classes personnages.</b>
 * <p>
 * Il existe 3 classes personnages :
 * <ul>
 * <li>Warrior/Guerrier</li>
 * <li>Scout/Rodeur</li>
 * <li>Magician/Mâge</li>
 * </ul>
 * </p>
 * @author elojito
 */
class Player {
    /**
    * Un joueur possède les attributs:
    * nom
    * niveau
    * points de vie
    * force
    * dextérité
    * intéligence
    * attaque basique
    * attaque spéciale
   */
    private String pName;
    private int pLevel;
    private int pHP;
    private int pStrength;
    private int pAgility;
    private int pIntel;
    private String basicAttack;
    private String specialAttack;

    /**
     * Constructeur du Player:
     * Les points de vie sont le level multiplié par 5.
     * @param pName nom du joueur
     * @param pLevel niveau du joueur
     * @param pHP points de vie du joueur
     * @param pStrength force du joueur
     * @param pAgility dextérité du joueur
     * @param pIntel intéligence du joueur
     */
    public Player(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        this.pName = pName;
        this.pLevel = pLevel;
        this.pHP = pLevel * 5;
        this.pStrength = pStrength;
        this.pAgility = pAgility;
        this.pIntel = pIntel;
    }

    /**
     * Retourne le nom du joueur
     * @return le nom du joueur sous forme d'une châne de caractère
     */
    public String getpName() { return pName; }
    /**
     * Retourne le niveau du joueur
     * @return le niveau sous forme d'un entier
     */
    public int getpLevel() { return pLevel;  }
    /**
     * Retourne les points de vie du joueur
     * @return les HP sous forme d'un entier
     */
    public int getpHP() { return pHP;  }
    /**
     * Retourne la force du joueur
     * @return la force sous forme d'un entier
     */
    public int getpStrength() {return pStrength; }
    /**
     * Retourne la dextérité du joueur
     * @return la dextérité sous forme d'un entier
     */
    public int getpAgility() {return pAgility; }
    /**
     * Retourne l'intelligence du joueur
     * @return l'intelligence sous forme d'un entier
     */
    public int getpIntel() {return pIntel; }
    /**
     * Retourne l'attaque basique du joueur selon la classe personnage choisie
     * @return l'attaque basique sous forme d'une chaîne de caractères
     * @see Warrior#getBasicAttack()
     * @see Scout#getBasicAttack()
     * @see Magician#getBasicAttack()
     */
    public String getBasicAttack() {return basicAttack; }
    /**
     * Retourne l'attaque spéciale du joueur selon la classe personnage choisie
     * @return l'attaque spéciale sous forme d'une chaîne de caractères
     * @see Warrior#getSpecialAttack()
     * @see Scout#getSpecialAttack()
     * @see Magician#getSpecialAttack()
     */
    public String getSpecialAttack() { return specialAttack; }

    /**
     * Met à jour le nom du  joueur
     * @param pName nom
     */
    public void setpName(String pName) { this.pName = pName;  }
    /**
     * Met à jour le niveau du  joueur
     * @param pLevel niveau
     */
    public void setpLevel(int pLevel) { this.pLevel = pLevel; }
    /**
     * Met à jour les points de vie du  joueur
     * @param pHP points de vie
     */
    public void setpHP(int pHP) {this.pHP = pHP; }
    /**
     * Met à jour la force du  joueur
     * @param pStrength force
     */
    public void setpStrength(int pStrength) {this.pStrength = pStrength; }
    /**
     * Met à jour la dextérité du  joueur
     * @param pAgility dextérité
     */
    public void setpAgility(int pAgility) {this.pAgility = pAgility; }
    /**
     * Met à jour l'intelligence du  joueur
     * @param pIntel intéligence
     */
    public void setpIntel(int pIntel) {this.pIntel = pIntel;}
    /**
     * Met à jour l'attaque basique du  joueur selon la classe choisie
     * @param basicAttack attaque  basique
     * @see Warrior#setBasicAttack(String)
     * @see Scout#setBasicAttack(String)
     * @see Magician#setBasicAttack(String)
     */
    void setBasicAttack(String basicAttack) {this.basicAttack = basicAttack;    }
    /**
     * Met à jour l'attaque spéciale du  joueur selon la classe choisie
     * @param specialAttack attaque spéciale
     * @see Warrior#setSpecialAttack(String)
     * @see Scout#setBasicAttack(String)
     * @see Magician#setSpecialAttack(String)
     */
    void setSpecialAttack(String specialAttack) {this.specialAttack = specialAttack; }

    /**
     * Affiche la desciption des caractéristiques du personnage final
     * Cette description est surchargée dans les différentes classes personnages,
     * afin d'ajouter en début de phrase un 'cri de guerre', et d'annoncer la classe du personnage.
     * @return la phrase d'introduction du joueur sous forme d'une chaîne de caractère, sans le cri de guerre et sans la classe
     * @see Warrior#description()
     * @see Scout#description()
     * @see Magician#description()
     */
    public String description() {
        String phrase = "de niveau " + pLevel + " avec " + pHP + " points de vie. J'ai une force de " + pStrength + ", agilité de " + pAgility + ", et une intélligence de " + pIntel + ".";
        return phrase;
    }

    /**
     * Appelle le joueur à choisir une action d'attaque avec actionchoice()
     * Avec ce choix, on appelle l'attaque basique ou l'attaque spéciale contre l'adversaire 'player'
     * @param player adversaire
     * @see #actionChoice()
     */
    public void attack(Player player){
        int attackChoice = actionChoice();
        if (attackChoice == 1)attackBasic(player);
        else if (attackChoice == 2)attackSpecial(player);
    }

    /**
     * On lance une attaque basique contre l'adversaire 'player'
     * @param player adversaire
     * @see Warrior#attackBasic(Player)
     * @see Scout#attackBasic(Player)
     * @see Magician#attackBasic(Player)
     */
    public void attackBasic(Player player){ }

    /**
     * On lance une attaque spéciale contre l'adversaire 'player'
     * @param player adversaire
     * @see Warrior#attackSpecial(Player)
     * @see Scout#attackSpecial(Player)
     * @see Magician#attackSpecial(Player)
     */
    public void attackSpecial(Player player){ }

    /**
     * Demande au joueur de choisir entre une attaque basique ou spéciale à lancer contre son adversaire
     * Le choix doit être 1 ou 2.
     * @return le choix d'attaque du joueur contre son adversaire sous forme d'un entier
     */
    private int  actionChoice(){
        int attackChoice = 0;
        boolean catched;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                catched = false;
                System.out.println(pName + " (vitalité " + pHP + "), veuillez choisir votre action: 1- attaque basique, 2- attaque spéciale:");
                attackChoice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                catched = true;
                sc.next();
            } finally {
                if ((attackChoice!=1) && (attackChoice!=2)) {
                    System.out.println("Saisie erronée");
                    catched = false;
                }
            }
        }
        while(((attackChoice!=1) && (attackChoice!=2))|| (catched));
        return attackChoice;
    }
}
