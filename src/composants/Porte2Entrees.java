package composants;

public abstract class Porte2Entrees extends Porte{
    public Composant In1;
    public Composant In2;

    public Composant getIn1() {
        return In1;
    }

    public Composant getIn2() {
        return In2;
    }

    public void setIn1(Composant in1) {
        In1 = in1;
    }

    public void setIn2(Composant in2) {
        In2 = in2;
    }
}
