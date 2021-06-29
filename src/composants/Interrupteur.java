package composants;

import signaux.SignalBas;
import signaux.SignalHaut;
import signaux.SignalLogique;

/*
La classe Interrupteur est publique et descend de Composant.

Elle contient une variable publique et globale de type SignalLogique qui correspond à son état actuel.
*/
public class Interrupteur extends Composant{

    protected SignalLogique etat;

    /*
    La méthode on() est publique.

    Elle change l'état logique de l'interrupteur vers un SignalHaut.
    */
    public void on() {
        etat = new SignalHaut();
    }

    /*
    La méthode off() est publique.

    Elle change l'état logique de l'interrupteur vers un SignalBas.
    */
    public void off() {
        etat = new SignalBas();
    }

    /*
    La méthode getEtat() est publique et renvoie un booléen.

    Elle retourne l'état logique de l'interrupteur en booléen.
    */
    public boolean getEtat() throws NonConnecteException {
        return etat.value();
    }

    /*
    La méthode description() est publique et renvoie un String.

    Elle renvoie, en chaine de caractère, l'ID de l'interrupteur.
    */
    @Override
    public String description() {
        return getId();
    }

    /*
    La méthode getType() est publique et renvoie un String.

    Elle renvoie, en chaine de caractère, le type de composant. Ici, "Interrupteur".
    */
    @Override
    public String getType() {
        return "Interrupteur";
    }

    /*
    La méthode evaluate() est publique et renvoie un SignalLogique.

    Elle renvoie l'état logique de l'interrupteur.
    */
    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        return etat;
    }
}
