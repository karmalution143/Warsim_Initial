package warrior;

public class Orc extends Warrior {

    private int minHealth = 75;
    private int maxHealth = 150;
    private int minStrength = 75;
    private int maxStrength = 150;
    private int maxDexterity = 175;
    private int minDexterity = 150;
    
    public Orc() {
        super(); // must be called first!
        super.setHealth(super.randNum.nextInt(maxHealth) + minHealth);
        super.setStrength(super.randNum.nextInt(maxStrength) + minStrength);
        super.setDexterity(super.randNum.nextInt(maxDexterity) + minDexterity);
    } // constructor
} // class