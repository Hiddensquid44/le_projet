package signaux;

public abstract class SignalLogique {

    public abstract boolean value();
    public boolean not() {return !this.value();}
    public boolean and(SignalLogique s) {return this.value() && s.value();}
    public boolean or(SignalLogique s) {return this.value() || s.value();}
    public abstract String toString();

}
