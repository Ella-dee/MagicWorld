package com.elodie.opcmagicworld;

public class Warrior extends Player{
    private String cIntro;
    private String cClass;

    public Warrior(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel,pHP, pStrength, pAgility, pIntel);
        this.cClass = "Je suis un Guerrier ";
        this.cIntro = "Beware!!!!!";
        this.setBasicAttack("coup d'épée");
        this.setSpecialAttack("coup de rage");
    }
    public String getcClass() { return cClass;}
    public String getcIntro() {return cIntro; }

    @Override
    public String description() {
        return cIntro + cClass + super.description();
    }
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
