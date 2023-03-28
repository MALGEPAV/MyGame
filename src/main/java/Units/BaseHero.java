package Units;

public abstract class BaseHero implements GameInterface{
    public String name;
    public int x;
    public int y;
    protected int strength, maxStrength;
    protected int armor, maxArmor;
    protected int armorBreak;

    public BaseHero(String name, int x, int y, int strength, int maxStrength, int armor, int maxArmor, int armorBreak) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.strength = strength;
        this.maxStrength = maxStrength;
        this.armor = armor;
        this.maxArmor = maxArmor;
        this.armorBreak = armorBreak;
    }

    protected void getStrengthDamage(int dmg) {
        this.strength -= Math.min(dmg, this.strength);
        if (strength==0) this.die();
    }
    protected void getArmorDamage(int armorDmg) {
        this.armor -= Math.min(armorDmg, this.armor);
    }

    protected void getHealing(int healPoints) {
        this.strength += Math.min(healPoints,this.maxStrength-this.strength);
    }
    protected void getArmorMending(int armorPoints) {
        this.armor += Math.min(armorPoints,this.maxArmor-this.armor);
    }

    protected double distanceFrom(BaseHero targetHero){
        return Math.sqrt(Math.pow(this.x - targetHero.x, 2) + Math.pow(this.y - targetHero.y, 2));
    }
    protected void die() {
        System.out.println(this.name+" dying...");
    }

    @Override
    public void turn() {

    }
}
