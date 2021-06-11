package composants;

public class Or extends Porte2Entrees{
    public Or(Composant In1, Composant In2){
        if (In1!=null){
            setIn1(In1);
        }
        if (In2!=null){
            setIn1(In2);
        }
    }
}
