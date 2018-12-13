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

}
