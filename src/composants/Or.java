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

    public Or()
    {

    }

    public boolean getEtat() throws NonConnecteException {
        boolean etat;
        if (In1.getEtat()==false && In2.getEtat()==false){
            etat=false;
        }
        else{
            etat=true;
        }
        return etat;
    }


}
