package composants;

public class Vanne extends Composant {
    public Composant In;

    public Vanne(Composant In){
        this.In = In;
    }

    public Vanne(){

    }

    public Composant getIn() {
        return In;
    }

    public void setIn(Composant in) {
        In = in;
    }

    @Override
    public String description() {
        String str, str1;
        if (In == null) {
            str1 = "non connecte";
        } else {
            str1 = In.getId();
        }
        str = getId() + " in: " + str1;
        return str;
    }

    @Override
    public boolean getEtat() throws NonConnecteException {
        if (In == null) {
            throw new NonConnecteException();
        }
        return In.getEtat();
    }
}
