package Units;

public class Mage extends SpellCaster {
    public Mage(String name, int x, int y) {
            super(20,20,name,x,y,7,7,7,7,0);
    }

    @Override
    protected void castSpell(BaseHero targetHero) {
    }
    @Override
    public String getInfo() {
        return "Маг "+this.name;
    }
}
