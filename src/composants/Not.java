package composants;

public class Not extends Porte{
    public Composant In;

    public Composant getIn() {
        return In;
    }

    public void setIn(Composant in) {
        In = in;
    }

    public Not(Composant In) {
        if (In != null) {
            setIn(In);
        }
    }

    public Not() {

    }

    @Override
    public String description(){
        String str,str1;
        if(In==null) {
            str1 = "non connecte";
        }
        else{
            str1 = In.getId();
        }
        str = getId() + " in: " + str1;
        return str;
    }

    public boolean getEtat() throws NonConnecteException {
        boolean etat;
        return etat;
    }
}
