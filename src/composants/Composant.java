package composants;

public abstract class Composant {
    public String getId(){
        return toString();
    }

    public abstract String description();
}