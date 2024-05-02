package armor;

public class Platemail extends Armor {
    private int armorAmount = 350;
    private int dexterityCost = 150;

    public Platemail() {
        super();
        super.setArmorAmount(armorAmount);
        super.setDexterityCost(dexterityCost);
    }

    public int getFinalDamage(int damage) {
        return damage - (this.armorAmount / 2);
    }
    
}