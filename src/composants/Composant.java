package composants;

public abstract class Composant {
    public String getID(){
        return toString();
    }

    public abstract String description();
}
