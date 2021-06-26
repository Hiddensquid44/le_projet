package composants;

import signaux.SignalBas;
import signaux.SignalHaut;
import signaux.SignalLogique;

public class Interrupteur extends Composant{

    protected SignalLogique etat;

    public void on() {
        etat = new SignalHaut();
    }
    public void off() {
        etat = new SignalBas();
    }
    public boolean getEtat() throws NonConnecteException {
        return etat.value();
    }

    @Override
    public String description() {
        return getId();
    }

    @Override
    public String getType() {
        return "Interrupteur";
    }

    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        return etat;
    }
}
