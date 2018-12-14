package com.elodie.opcmagicworld;
/**
 * <b>Scout est une classe enfant de Player représentant la classe Rôdeur.</b>
 * <p>
 * Il possède deux attributs qui lui sont propres :
 * <ul>
 * <li>cri de guerre: *apparait par derrière en toute discrétion*</li>
 * <li>introduction de classe: Je suis un Rôdeur </li>
 * </ul>
 * </p>
 * <p>
 * Il possède deux attaques qui lui sont propres:
 * <ul>
 * <li>attaque basique: tir à l'arc</li>
 * <li>attaque spéciale: concentration</li>
 * </ul>
 * </p>
 * @author elojito
 */
public class Scout extends  Player {
    private final String cIntro;
    private final String cClass;

    /**
     * Constructeur du Rodeur
     * Personalisation des attributs 'présentation de classe' et 'cri de guerre'.
     * Personalisation des attaques basique et spéciale.
     * @param pName nom du joueur
     * @param pLevel niveau du joueur
     * @param pHP points de vie du joueur
     * @param pStrength force du joueur
     * @param pAgility dextérité du joueur
     * @param pIntel intéligence du joueur
     */
    public Scout(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel, pHP, pStrength, pAgility, pIntel);
        this.cClass = "Je suis un Rôdeur ";
        this.cIntro = "*apparait par derrière en toute discrétion* ";
        this.setBasicAttack("tir à l'arc");
        this.setSpecialAttack("concentration");
    }

    /**
     * Implémente la description du Rodeur
     * @return cri de guerre, introduction de classe, et description des caractéristiques du joueur
     * @see Player#description()
     */
    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
    /**
     * L'attaque basique du Rodeur contre un adversaire 'player'
     * Effectue des dommages égaux à l’agilité du Rodeur.
     * Affiche les points de vie perdus par l'adversaire.
     * Met à jour les points de vie de l'adversaire.
     * Vérifie si l'adversaire est mort (points de vie à zéro)
     * @param player adversaire
     */
    @Override
    public void attackBasic(Player player){
        int damages = this.getpAgility();
        System.out.println(getpName()+" utilise "+getBasicAttack()+" et inflige "+damages+" dommages");
        player.setpHP(player.getpHP()- damages);
        System.out.println(player.getpName()+" perd "+ damages+ " points de vie.");
        if(player.getpHP()<=0){
            System.out.println(player.getpName() + " est mort.");
            System.out.println(player.getpName()+" a perdu!");
        }
    }
    /**
     * L'attaque spéciale du Rodeur
     * Le joueur gagne son niveau divisé par 2 en agilité.
     * Met à jour les points d'agilité du rodeur et l'affiche.
     * @param player le Rodeur lui-même
     */
    @Override
    public void attackSpecial(Player player){
        int concentration = this.getpLevel()/2;
        System.out.println(getpName()+" utilise "+getSpecialAttack()+" et gagne "+concentration+" points en agilité");
        this.setpAgility(this.getpAgility() + concentration);
    }
}
