package composants;

import signaux.SignalLogique;

public interface Evaluable {
    public SignalLogique evaluate() throws NonConnecteException;
}
