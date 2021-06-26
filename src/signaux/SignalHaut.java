package signaux;

public class SignalHaut extends SignalLogique{

    @Override
    public boolean value() {
        return true;
    }

    @Override
    public String toString() {
        return "true";
    }

}
