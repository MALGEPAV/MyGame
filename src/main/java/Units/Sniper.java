package Units;

import java.util.Random;

public class Sniper extends RangeAttackUnit {
    @Override
    protected void rangeStrengthAttack(BaseHero targetHero) {
        if (new Random().nextInt(1, 101) <= this.accuracy)
            targetHero.getStrengthDamage(Math.max(this.strength - targetHero.armor, 0));
        else System.out.println(this.name + " misses...");
    }

    public Sniper(String name, int x, int y) {
        super(10, 10, 70, name, x, y, 15, 15, 8, 8, 5);
    }

    @Override
    public String getInfo() {
        return "Снайпер "+this.name;
    }
}
