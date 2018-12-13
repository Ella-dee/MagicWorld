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

}
