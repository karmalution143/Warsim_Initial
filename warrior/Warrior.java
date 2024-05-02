package warrior;
import java.util.Random;

// Abstract makes it a parent!
// also protects it from being instantiated!
public abstract class Warrior {

    // public is open to everyone
    // protected is private outside, public inside
    
    protected Random randNum = new Random();
    private int health;
    private int strength;
    private int dexterity;

    public Warrior() {

        //do nothing
    }

    //=============>>
    //GETTERS

    public int getHealth() {
        return this.health;
    }
    public int getStrength() {
        return this.strength;
    }
    public int getDexterity() {
        return this.dexterity;
    }

    //=============>>
    //SETTERS

    public void setHealth(int health) {
        this.health = health;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public void takeDamage(int damagaAmount) {
        if(damagaAmount > 0)
        this.health -= damagaAmount;
    }
} // class