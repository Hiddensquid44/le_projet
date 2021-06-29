package signaux;

/*
La classe SignalHaut est publique et descend de SignalLogique.
*/
public class SignalHaut extends SignalLogique{

    /*
    La méthode value() est publique et renvoie un booléen.

    Elle renvoie la valeur du signal logique, ici true.
    */
    @Override
    public boolean value() {
        return true;
    }

    /*
    La méthode toString() est publique et renvoie un String.

    Elle renvoie, en chaine de caractères, l'état d'un signal logique, ici "true".
    */
    @Override
    public String toString() {
        return "true";
    }

}
