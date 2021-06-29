package signaux;

/*
La classe SignalBas est publique et descend de SignalLogique.
*/
public class SignalBas extends SignalLogique {

    /*
    La méthode value() est publique et renvoie un booléen.

    Elle renvoie la valeur du signal logique, ici false.
    */
    @Override
    public boolean value() {
        return false;
    }

    /*
    La méthode toString() est publique et renvoie un String.

    Elle renvoie, en chaine de caractères, l'état d'un signal logique, ici "false".
    */
    @Override
    public String toString() {
        return "false";
    }

}
