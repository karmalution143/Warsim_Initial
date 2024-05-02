import warrior.*;
import weapon.*;
import armor.*;
import utility.*;
import java.util.Scanner;
import java.util.Random;


public class Warsim {

    public static Scanner input = new Scanner(System.in);
    public static Random randNum = new Random();
    public static Ink ink = new Ink();
    
    public static Warrior player; //player
    public static Weapon pWeapon; // player weapon
    public static Armor pArmor; // player armor

    public static Warrior enemy; // enemy
    public static Weapon eWeapon; // enemy weapon
    public static Armor eArmor; // enemy armor

    // Game Vars
    public static boolean gameOver = false;
    public static boolean playerTurn = true;
    public static String who = "Player";
    public static String winner = "";
    public static int choice = 0;
    public static int attackType = 0;
    public static int damage = 0;

    // ===============>>
    // main method
    public static void main(String[] args) {

        // Welcome
        ink.Welcome();

        //================>>
        // Character Setup
        System.out.println("What is your name: ");
        String name = input.nextLine();

        System.out.println("Welcome " + name);

        //Player Creation
        // Warrior
        ink.printWarriorMenu();
        int choice = input.nextInt();
        createWarrior(who, choice);

        // Weapon
        ink.printWeaponMenu();
        choice = input.nextInt();
        createWeapon(who, choice);

        
        // Armor
        ink.printArmorMenu();
        choice = input.nextInt();
        createArmor(who, choice);
        
        // set who to Enemy
        who = "Enemy";

        // Enemy Creation
        // Warrior
        choice = randNum.nextInt(3) + 1;
        createWarrior(who, choice);

        // Weapon
        choice = randNum.nextInt(3) + 1;
        createWeapon(who, choice);

        // Armor
        choice = randNum.nextInt(3) + 1;
        createArmor(who, choice);

        System.out.println("Health: " + player.getHealth());
        System.out.println("Strength: " + player.getStrength());
        System.out.println("Dexterity: " + player.getDexterity());
        System.out.printf("Your Weapon does: %d damage\nWith a Dexterity cost of: %d\n",
            pWeapon.getDamageAmount(), pWeapon.getDexterityCost());

        System.out.println("Enemy");
        System.out.println("Health: " + enemy.getHealth());
        System.out.println("Strength: " + enemy.getStrength());
        System.out.println("Dexterity: " + enemy.getDexterity());

        //================>>
        //Main Game Loop
        while(!gameOver) {
            if(playerTurn) {

                ink.printAttackMenu();
                attackType = input.nextInt();
                damage = pWeapon.strike(attackType,
                    player.getDexterity(),
                    player.getStrength());

                damage = eArmor.getFinalDamage(damage);

                System.out.println("Damage amount is: " + damage);

                enemy.takeDamage(damage);

                if(enemy.getHealth() <= 0) {
                    winner = "Player";
                    gameOver = !gameOver;
                }
                playerTurn = !playerTurn; // toggles player turn
                }
                else {
                    // enemy code
                    System.out.println("Enemy Turn!");
                    playerTurn = !playerTurn; // toggles player turn  
                }
                
        } // while
    System.out.println("Game Over! Winner is " + winner);
    } // main
    
    //============>>
    // Helper Methods
    public static void createWarrior(String who, int choice) {
        if(who.equals("Player")) {
        switch (choice) {
            case 1:
            if(who.equals("Player")) {
                player = new Human();
            }
            else {
                enemy = new Human();
            }
                break;
            case 2:
            if(who.equals("Player")) {
                player = new Elf();
            }
            else{
                enemy = new Elf();
            }
                break;
            case 3:
            if(who.equals("Player")) {
                player = new Orc();
            }
            else {
                enemy = new Orc();
            }
                break;
            default:
                System.out.println("Invalid choice! Please choose a valid option.");
                break;
        }
        } // switch
    } // createWarrior

    public static void createWeapon(String who, int choice) {
        
        switch (choice) {
            case 1:
            if(who.equals("Player")) {
                pWeapon = new Axe();
            }
            else {
                eWeapon = new Axe();
            }
                break;
            case 2:
            if(who.equals("Player")) {    
                pWeapon = new Dagger();
            }
            else {
                eWeapon = new Dagger();
            }
                break;
            case 3:
            if(who.equals("Player")) { 
                pWeapon = new Sword();
            }
            else {
                eWeapon = new Sword();
            }
                break;
            default:
                System.out.println("Oops!");
                break;
        } // switch
    } // createWeapon

    public static void createArmor(String who, int choice) {
        switch(choice) {
            case 1: // Leather
            if(who.equals("Player")) {
                pArmor = new Leather();
            }
            else {
                eArmor = new Leather();
            }
                break;
            case 2: // Chainmail
            if(who.equals("Player")) {
                pArmor = new Chainmail();
            }
            else {
                eArmor = new Chainmail();
            }
                break;
            case 3: //Platemail
            if(who.equals("Player")) {
                pArmor = new Platemail();
            }
            else {
                eArmor = new Platemail();
            }
                break;
            default:
                System.out.println("Oops!");
                break;
        }
    }
} // class
