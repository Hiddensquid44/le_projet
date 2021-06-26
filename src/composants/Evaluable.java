package composants;

import signaux.SignalLogique;

/*
L'interface Evaluable est publique et retourne un SignalLogique.

Toutes les classes qui l'implémente doivent avoir une méthode evaluate().

La méthode evaluate() sera appelée de façon récursive des vannes d'un circuit vers les interrupteurs.
Les signaux logiques remonteront jusqu'aux vannes et on pourra alors définir si elles sont allumées ou éteintes.
*/
public interface Evaluable {
    public SignalLogique evaluate() throws NonConnecteException;
}
