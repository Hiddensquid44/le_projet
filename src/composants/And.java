package composants;

public class And extends Porte2Entrees{
    public And(Composant In1, Composant In2){
        if (In1!=null){
            setIn1(In1);
        }
        if (In2!=null){
            setIn2(In2);
        }
    }

    public And(){

    }

    public boolean getEtat() throws NonConnecteException {
        boolean etat;
        if (In1 == null || In2 == null) {
            throw new NonConnecteException();
        }
        if (In1.getEtat()==true && In2.getEtat()==true){
            etat=true;
        }
        else{
            etat=false;
        }
        return etat;
    }

    public String getType() {
        return "And";
    }
}
