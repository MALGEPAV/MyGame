package Units;

public class SpearMan extends MeleeAttackUnit {
    public SpearMan(String name, int x, int y){

        super(3,name,x,y,11,11,10,10,3);
    }
    @Override
    public String getInfo() {
        return "Копейщик "+this.name;
    }
}
