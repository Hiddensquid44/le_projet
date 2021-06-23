package signaux;

public class SignalBas extends SignalLogique {

    @Override
    public boolean value() {
        return false;
    }

    @Override
    public String toString() {
        return "false";
    }

}
