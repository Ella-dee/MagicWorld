package com.elodie.opcmagicworld;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * <b>Game est la classe pour le déroulement du jeu.</b>
 * <p>
 * Premièrement il y a la création des deux personnages :
 * <ul>
 * <li>choix de la classe personnage: Warrior, Scout ou Magician</li>
 * <li>choix du level: ne peut être zéro et maximum 100</li>
 * <li>choix des caractéristiques:
 * <ol>
 *     <li>force</li><li>agilité</li><li>intéligence</li>
 * </ol><
 * /li>
 * <li>Ces caractéristiques peuvent être à zéro, mais leur somme ne doit pas dépasser le 'level'</li>
 * <li>La caractéristique HP, se base sur le level. Les points de vies seront ainsi égaux au niveau multiplié par 5.</li>
 * </ul>
 * </p>
 * <p>
 * Puis les joueurs choisissent entre attaque basique ou spéciale jusqu'à la mort de l'un des deux (points de vue à zéro).
 * </p>
 * @author elojito
 */

class Game {
    /**
     * Lance le jeu depuis le 'main'.
     * Appelle l'instanciation des deux personnages
     * Lance les combats avec player.attack()
     * @see Player
     * Les combats tournent en boucle jusqu'à ce que les points de vie d'un joueur tombent à zéro.
     */
    static void start() {
        System.out.println("Bienvenu-e dans Magic World!!!!");
        System.out.println("Création du personnage Joueur 1");
        Player player1 = enterPlayer();
        player1.setpName("Joueur 1");
        System.out.println(player1.description());
        System.out.println("Création du personnage Joueur 2");
        Player player2 = enterPlayer();
        player2.setpName("Joueur 2");
        System.out.println(player2.description());
        do {
            player1.attack(player2);
            if(player2.getpHP() > 0) {
                player2.attack(player1);
            }
        }while((player1.getpHP()>0)&&(player2.getpHP()>0));

    }
    /**
     * Appelle la méthode chooseClass() pour connaitre le choix de classe du joueur.
     * Selon le choix, on instancie un personnage 'vide' de la classe correspondante.
     * @see Warrior
     * @see Scout
     * @see Magician
     * On lance setStats pour construire le personnage.
     * On retourne le perso créé.
     * @return player
     * @return enterplayer()
     */
    private static Player enterPlayer() {
        int uClass = chooseClass();
        if (uClass == 1) {
            Warrior player = new Warrior("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        } else if (uClass == 2) {
            Scout player = new Scout("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        } else if (uClass == 3) {
            Magician player = new Magician("", 0, 0, 0, 0, 0);
            setStats(player);
            return player;
        }
        return enterPlayer();
    }
    /**
     * Une fois la classe personnage choisie, on demande au joueur d'alimenter les caractéristiques du personnage.
     * On injecte ensuite les caractéristiques dans le constructeur du perso.
     * @see Player
     */
    private static void setStats(Player player){
        player.setpLevel(levelSetUp());
        player.setpHP(player.getpLevel()*5);
        player.setpStrength(strengthSetUp(player));
        player.setpAgility(agilitySetUp(player));
        player.setpIntel(intelSetUp(player));
    }

    /**
     * Choix du niveau 'level' du personnage par le joueur.
     * Ne peut être zéro, et est au maximum à 100.
     * @return level
     */
    private static int levelSetUp(){
        int level = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("niveau: ");
                level = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                sc.next();
            }finally {
                if (level < 1 || level > 100) {
                    System.out.println("Votre choix n'est pas compris entre 1 et 100");
                }}
        } while ((level < 1) || (level > 100));
        return level;
    }
    /**
     * Choix de la force 'strength' du personnage par le joueur.
     * Peut être zéro, et est au maximum à 100.
     * Ne doit pas dépasser level.
     * @return strength
     */
    private static int strengthSetUp(Player player){
        int strength = 0;
        int totalLeft = player.getpLevel();
        Scanner sc = new Scanner(System.in);
        boolean catched;
        do {
            try {
                catched = false;
                System.out.print("force: ");
                strength = sc.nextInt();
            } catch (InputMismatchException e2) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                catched = true;
                sc.next();
            }finally {
                if(strength>totalLeft){
                    catched = false;
                    System.out.println("La somme totale de vos caractéristiques ne doit pas dépasser votre niveau");
                    System.out.println("Il vous reste " + totalLeft + " points à assigner");
                }
            }
        } while ((strength < 0) || (strength > 100)||(strength>totalLeft)||(catched));
        return strength;
    }
    /**
     * Choix de la dextérité 'agility' du personnage par le joueur.
     * Peut être zéro, et est au maximum à 100.
     * Ne doit pas dépasser la somme de level et strength.
     * @return agility
     */
    private static int agilitySetUp(Player player){
        int agility = 0;
        boolean catched;
        int totalLeft = player.getpLevel()-player.getpStrength();
        Scanner sc = new Scanner(System.in);
        do {
            try {
                catched = false;
                System.out.print("agilité: ");
                agility = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                catched = true;
                sc.next();
            }finally {

                if(agility>totalLeft){
                    System.out.println("La somme totale de vos caractéristiques ne doit pas dépasser votre niveau");
                    System.out.println("Il vous reste " + totalLeft + " points à assigner");
                }
            }
        } while ((agility < 0) || (agility > 100)||(agility>totalLeft)||(catched));
        return agility;
    }
    /**
     * Choix de l'intéligence 'intel' du personnage par le joueur.
     * Peut être zéro, et est au maximum à 100.
     * Ne doit pas dépasser la somme de level,strength et agility.
     * @return intel
     */
    private static int intelSetUp(Player player){
        int intel = 0;
        boolean catched;
        int totalLeft = player.getpLevel()-player.getpStrength()-player.getpAgility();
        Scanner sc = new Scanner(System.in);
        do {
            try {
                catched = false;
                System.out.print("intéligence: ");
                intel = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                catched = true;
                sc.next();
            }finally {
                if(intel>totalLeft){
                    System.out.println("La somme totale de vos caractéristiques ne doit pas dépasser votre niveau");
                    System.out.println("Il vous reste " + totalLeft + " points à assigner");
                }
            }
        } while ((intel < 0) || (intel > 100)||(intel>totalLeft)||(catched));
        return intel;
    }
    /**
     * Choix de la classe personnage par le joueur.
     * Choix 1, 2 ou 3.
     * @return uClass
     */
    private static int chooseClass(){
        Scanner sc = new Scanner(System.in);
        int uClass = 0;
        do {
            try{
                System.out.print("Veuillez choisir la classe de votre personnage: 1 - Guerrier, 2 - Rôdeur, 3 - Magicien: ");
                uClass = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Saisie erronée, votre choix n'est pas un nombre");
                sc.next();
            }
        } while ((uClass != 1) && (uClass != 2) && (uClass != 3));
        return uClass;
    }

    /**
     * Une fois les attaques arrêtées et qu'un joueur a perdu, affiche GAME OVER.
     * @return endgame
     */
    static String stop(){
        String endgame = "GAME OVER!";
        System.out.println(endgame);
        return endgame;
    }
}
