package Units;

public class Peasant extends BaseHero {
    public Peasant(String name, int x, int y) {
        super(name, x, y, 7, 7, 5, 5, 0);
    }

    private void mendArmor(BaseHero targetHero) {
            targetHero.getArmorMending(Math.min(targetHero.maxArmor - targetHero.armor, 3));
    }
    @Override
    public String getInfo() {
        return "Крестьянин "+this.name;
    }
}
