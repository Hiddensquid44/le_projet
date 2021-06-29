package signaux;

/*
La classe SignalLogique est publique et abstraite.

Les méthodes logiques not(), and(SignalLogique s) et or(SignalLogique s) ne sont pas abstraites
car elles ne dépendent pas de la valeur du SignalLogique étant donné qu'elles appellent la méthode
value() retournant la valeur du SignalLogique.
*/
public abstract class SignalLogique {

    /*
    La méthode value() est publique, abstraite et renvoie un booléen.

    Elle renvoie la valeur du signal logique.
    */
    public abstract boolean value();

    /*
    La méthode not() est publique et renvoie un SignalLogique.

    Elle renvoie le signal logique inverse d'un signal.
    */
    public SignalLogique not() {
        if (!value())    return new SignalHaut();
        else            return new SignalBas();
    }

    /*
    La méthode and() est publique et renvoie un SignalLogique.

    Elle renvoie le signal logique correpondant à l'opération logique "and" de deux signaux logiques.
    */
    public SignalLogique and(SignalLogique s) {
        if (value() && s.value())   return new SignalHaut();
        else    return new SignalBas();
    }

    /*
    La méthode or() est publique et renvoie un SignalLogique.

    Elle renvoie le signal logique correpondant à l'opération logique "or" de deux signaux logiques.
    */
    public SignalLogique or(SignalLogique s) {
        if (!value() && !s.value()) return new SignalBas();
        else    return new SignalHaut();
    }

    /*
    La méthode toString() est publique, abstraite et renvoie un String.

    Elle renvoie, en chaine de caractères, l'état d'un signal logique.
    */
    public abstract String toString();

}
