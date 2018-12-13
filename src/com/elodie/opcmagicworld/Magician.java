package com.elodie.opcmagicworld;

public class Magician extends Player {
    private String cIntro;
    private String cClass;

    public Magician(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel, pHP, pStrength, pAgility, pIntel);
        this.cClass = "Je suis un Magicien ";
        this.cIntro = "Expecto Patronum!!!!! ";
        this.setBasicAttack("boule de feu");
        this.setSpecialAttack("soin");
    }
    public String getcClass() {
        return cClass;
    }
    public String getcIntro() { return cIntro; }

    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
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

    @Override
    public void attackSpecial(Player player){
        int cure = checkCure();
        System.out.println(getpName()+" utilise "+getSpecialAttack()+" et gagne "+cure+" points de vie");
        this.setpHP(this.getpHP()+cure);
    }

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
