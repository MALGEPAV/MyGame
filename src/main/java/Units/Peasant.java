package Units;
import Aux.Pos;

public class Peasant extends BaseHero {
    public Peasant(String name, Pos pos) {
        super(name, pos, 7, 7, 5, 5, 0);
    }

    private void mendArmor(BaseHero targetHero) {
            targetHero.getArmorMending(Math.min(targetHero.maxArmor - targetHero.armor, 3));
    }
    @Override
    public String getInfo() {
        return "Крестьянин "+this.name;
    }
}
