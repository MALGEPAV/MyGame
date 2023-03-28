package Units;

import java.util.Random;

public class CrossBowman extends RangeAttackUnit {
    private final int WEAPONDAMAGE;
    @Override
    protected void rangeStrengthAttack(BaseHero targetHero) {
        if (new Random().nextInt()<=this.accuracy) targetHero.getStrengthDamage(this.WEAPONDAMAGE-targetHero.armor);
        else System.out.println(this.name + " misses...");
    }
    public CrossBowman(String name, int x, int y) {
        super(15,10,85,name,x,y,10,10,10,10,3);
        this.WEAPONDAMAGE = 10;
    }
    @Override
    public String getInfo() {
        return "Арбалетчик "+this.name;
    }
}
