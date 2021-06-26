package signaux;

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
