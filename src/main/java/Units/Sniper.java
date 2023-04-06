package Units;

import Aux.Pos;

import java.util.ArrayList;
import java.util.Random;

public class Sniper extends RangeAttackUnit {

    public Sniper(String name, Pos pos) {
        super(10, 10, 70, name, pos, 15, 15, 8, 8, 5, 9);
    }

    @Override
    public void attackTarget() {
        if (new Random().nextInt(1, 101) <= this.accuracy) {
            if ((float) (this.strength - this.targetHero.armor) / (float) this.targetHero.strength >= 0.2){
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks str of " + this.targetHero.getInfo() + " " + this.targetHero.name);
                this.targetHero.getStrengthDamage(Math.max(this.strength - this.targetHero.armor, 0));
            }else{
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks armor of " + this.targetHero.getInfo() + " " + this.targetHero.name);
                this.targetHero.getArmorDamage(this.armorBreak);
            }
        } else {
            System.out.println(this.getInfo() + " " + this.name + " misses "+
                    "trying to attack "+this.targetHero.getInfo()+" "+this.targetHero.name);
        }

    }

    @Override
    public String getInfo() {
        return "Снайпер ";
    }
}
