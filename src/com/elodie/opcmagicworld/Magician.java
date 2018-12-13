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
}
