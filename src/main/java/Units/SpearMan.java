package Units;
import Aux.Pos;


public class SpearMan extends MeleeAttackUnit {
    public SpearMan(String name, Pos pos){

        super(2,name,pos,10,10,12,12,3, 7);
    }
    @Override
    public String getInfo() {
        return "Копейщик ";
    }
}
