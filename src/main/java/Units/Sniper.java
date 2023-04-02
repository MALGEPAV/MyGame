package Units;
import Aux.Pos;

import java.util.ArrayList;
import java.util.Random;

public class Sniper extends RangeAttackUnit {
    @Override
    protected void rangeStrengthAttack(BaseHero targetHero) {
        if (new Random().nextInt(1, 101) <= this.accuracy)
            targetHero.getStrengthDamage(Math.max(this.strength - targetHero.armor, 0));
        else System.out.println(this.name + " misses...");
    }

    public Sniper(String name, Pos pos) {

        super(10, 10, 70, name, pos, 15, 15, 8, 8, 5);
    }
    @Override
    public String getInfo() {
        return "Снайпер "+this.name;
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.turn(enemies, allies);
        if ((float)(this.strength-targetHero.armor)/ (float)targetHero.strength >= 0.2)
            this.rangeStrengthAttack(targetHero);
        else this.rangeArmorAttack(targetHero);
    }
}
