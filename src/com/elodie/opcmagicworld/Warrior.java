package com.elodie.opcmagicworld;
/**
 * <b>Warrior est une classe enfant de Player représentant la classe Guerrier.</b>
 * <p>
 * Il possède deux attributs qui lui sont propres :
 * <ul>
 * <li>cri de guerre: Beware!!!!!</li>
 * <li>introduction de classe: Je suis un Guerrier  </li>
 * </ul>
 * </p>
 * <p>
 * Il possède deux attaques qui lui sont propres:
 * <ul>
 * <li>attaque basique: coup d'épée</li>
 * <li>attaque spéciale: coup de rage</li>
 * </ul>
 * </p>
 * @author elojito
 */
public class Warrior extends Player{
    private final String cIntro;
    private final String cClass;
    /**
     * Constructeur du Guerrier
     * Personalisation des attributs 'présentation de classe' et 'cri de guerre'.
     * Personalisation des attaques basique et spéciale.
     * @param pName nom du joueur
     * @param pLevel niveau du joueur
     * @param pHP points de vie du joueur
     * @param pStrength force du joueur
     * @param pAgility dextérité du joueur
     * @param pIntel intéligence du joueur
     */
    public Warrior(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel,pHP, pStrength, pAgility, pIntel);
        this.cClass = "Je suis un Guerrier ";
        this.cIntro = "Beware!!!!!";
        this.setBasicAttack("coup d'épée");
        this.setSpecialAttack("coup de rage");
    }
    /**
     * Implémente la description du Guerrier
     * @return cri de guerre, introduction de classe, et description des caractéristiques du joueur
     * @see Player#description()
     */
    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
    /**
     * L'attaque basique du Guerrier contre un adversaire 'player'
     * Effectue des dommages égaux à la force du joueur sur l’adversaire.
     * Affiche les points de vie perdus par l'adversaire.
     * Met à jour les points de vie de l'adversaire.
     * Vérifie si l'adversaire est mort (points de vie à zéro)
     * @param player adversaire
     */
    @Override
    public void attackBasic(Player player){
        int damages = this.getpStrength();
        System.out.println(getpName()+" utilise "+getBasicAttack()+" et inflige "+damages+" dommages");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" perd "+ damages+ " points de vie.");
        if(player.getpHP()<=0) {
            String dead = player.getpName() + " est mort.";
            System.out.println(dead);
        }
    }
    /**
     * L'attaque spéciale du Guerrier contre un adversaire 'player'
     * Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire.
     * Le joueur lançant l'attaque perd de la vitalité : la valeur de sa force divisée par 2.
     * Affiche les points de vie perdus par l'adversaire.
     * Met à jour les points de vie de l'adversaire.
     * Affiche les points de vie perdus par le Guerrier.
     * Met à jour les points de vie du Guerrier.
     * Vérifie si l'adversaire est mort (points de vie à zéro)
     * Vérifie si le Guerrier est mort (points de vie à zéro)
     * @param player adversaire
     */
    @Override
    public void attackSpecial(Player player){
        int damages = this.getpStrength()*2;
        System.out.println(getpName()+" utilise "+getSpecialAttack()+" et inflige "+damages+" dommages");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" perd "+ damages + " points de vie.");
        if(player.getpHP()<=0){
            System.out.println(player.getpName() + " est mort.");
            System.out.println(player.getpName()+" a perdu!");
        }

        int backfire = this.getpStrength()/2;
        System.out.println(this.getpName()+" perd "+ backfire + " points de vie.");
        this.setpHP(this.getpHP()- backfire);
        if(this.getpHP()<=0){
            System.out.println(this.getpName()+" est mort.");
            System.out.println(this.getpName()+" a perdu!");
        }
    }

}
