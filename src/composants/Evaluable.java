package composants;

import signaux.SignalLogique;

/*
L'interface Evaluable est publique et retourne un SignalLogique.

Toutes les classes qui l'implémente doivent avoir une méthode evaluate().
*/
public interface Evaluable {
    public SignalLogique evaluate() throws NonConnecteException;
}
