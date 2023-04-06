package Units;
import Aux.Pos;


public class SpearMan extends MeleeAttackUnit {
    public SpearMan(String name, Pos pos){

        super(3,name,pos,11,11,10,10,3, 7);
    }
    @Override
    public String getInfo() {
        return "Копейщик ";
    }
}
