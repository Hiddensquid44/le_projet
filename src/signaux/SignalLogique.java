package signaux;

/*
La classe SignalLogique est publique et abstraite.

Les méthodes logiques not(), and(SignalLogique s) et or(SignalLogique s) sont implémentées
ici car elles ne dépendent pas de la valeur du SignalLogique comme elles appellent la méthode
value() retournant la valeur du SignalLogique.
*/
public abstract class SignalLogique {

    public abstract boolean value();
    public SignalLogique not() {
        if (!value())    return new SignalHaut();
        else            return new SignalBas();
    }
    public SignalLogique and(SignalLogique s) {
        if (value() && s.value())   return new SignalHaut();
        else    return new SignalBas();
    }
    public SignalLogique or(SignalLogique s) {
        if (!value() && !s.value()) return new SignalBas();
        else    return new SignalHaut();
    }
    public abstract String toString();

}
