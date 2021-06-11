package composants;

public class And extends Porte2Entrees{
    public And(Composant In1, Composant In2){
        if (In1!=null){
            setIn1(In1);
        }
        if (In2!=null){
            setIn1(In2);
        }
    }

    @Override
    public String getType() {
        return "And";
    }
}
