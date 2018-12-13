package com.elodie.opcmagicworld;

public class Scout extends  Player {
    private String cIntro;
    private String cClass;

    public Scout(String pName, int pLevel, int pHP, int pStrength, int pAgility, int pIntel) {
        super(pName, pLevel, pHP, pStrength, pAgility, pIntel);
        this.cClass = "Je suis un Rôdeur ";
        this.cIntro = "*apparait par derrière en toute discrétion* ";
        this.setBasicAttack("tir à l'arc");
        this.setSpecialAttack("concentration");
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
        int damages = this.getpAgility();
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
        int concentration = this.getpLevel()/2;
        System.out.println(getpName()+" utilise "+getSpecialAttack()+" et gagne "+concentration+" points en agilité");
        this.setpAgility(this.getpAgility() + concentration);
    }
}
