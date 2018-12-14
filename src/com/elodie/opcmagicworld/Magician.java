package com.elodie.opcmagicworld;
/**
 * <b>Magician est une classe enfant de Player représentant la classe Mâge.</b>
 * <p>
 * Il possède deux attributs qui lui sont propres :
 * <ul>
 * <li>cri de guerre: Expecto Patronum!!!!!</li>
 * <li>introduction de classe: Je suis un Magicien</li>
 * </ul>
 * </p>
 * <p>
 * Il possède deux attaques qui lui sont propres:
 * <ul>
 * <li>attaque basique: boule de feu</li>
 * <li>attaque spéciale: soin</li>
 * </ul>
 * </p>
 * @author elojito
 */
public class Magician extends Player {
    private final String cIntro;
    private final String cClass;
    /**
     * Constructeur du Magicien
     * Personalisation des attributs 'présentation de classe' et 'cri de guerre'.
     * Personalisation des attaques basique et spéciale.
     * @param pName nom du joueur
     * @param pLevel niveau du joueur
     * @param pHP points de vie du joueur
     * @param pStrength force du joueur
     * @param pAgility dextérité du joueur
     * @param pIntel intéligence du joueur
     */
    public Magician(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel, pHP, pStrength, pAgility, pIntel);
        this.cClass = "Je suis un Magicien ";
        this.cIntro = "Expecto Patronum!!!!! ";
        this.setBasicAttack("boule de feu");
        this.setSpecialAttack("soin");
    }
    /**
     * Implémente la description du Magicien
     * @return cri de guerre, introduction de classe, et description des caractéristiques du joueur
     * @see Player#description()
     */
    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
    /**
     * L'attaque basique du Magicien contre un adversaire 'player'
     * Effectue des dommages égaux à l’intelligence du joueur sur l’adversaire.
     * Affiche les points de vie perdus par l'adversaire.
     * Met à jour les points de vie de l'adversaire.
     * Vérifie si l'adversaire est mort (points de vie à zéro)
     * @param player adversaire
     */
    @Override
    public void attackBasic(Player player){
        int damages = this.getpIntel();
        System.out.println(getpName()+" utilise "+getBasicAttack()+" et inflige "+damages+" dommages");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" perd "+ damages+ " points de vie.");
        if(player.getpHP()<=0){
            System.out.println(player.getpName() + " est mort.");
            System.out.println(player.getpName()+" a perdu!");
        }
    }
    /**
     * L'attaque spéciale du Magicien
     * Le joueur soigne sa vie et regagne sa quantité d’intelligence fois 2 en points de vie.
     * Il ne peut pas avoir plus de vie qu’il n’en avait au départ.
     * Met à jour les points de vie du magicien et l'affiche.
     * @param player le Magicien lui-même
     * @see #checkCure()
     */
    @Override
    public void attackSpecial(Player player){
        int cure = checkCure();
        System.out.println(getpName()+" utilise "+getSpecialAttack()+" et gagne "+cure+" points de vie");
        this.setpHP(this.getpHP()+cure);
    }

    /**
     * Vérifie que le maagicien ne gagne pas plus de points de vie qu'il n'en avait au départ
     * On récupère les points de vie de départ du magicien
     * On calcule les points de vies gagnés par le sort soin
     * On soustrait afin d'appliquer la valeur maximale possible à récupérer
     * @return le nombre de points de vie récupérés par le sort soin
     */
    public int checkCure(){
        int intel = this.getpIntel()*2;
        int hp = this.getpHP();
        int startHP = this.getpLevel()*5;
        int cure = hp + intel;
        int possibleCure = startHP - hp;
        if(cure>possibleCure)cure = possibleCure;
        return cure;
    }
}
