package composants;

public abstract class Composant implements Comparable <Composant>{
    public String getId(){
        return toString();
    }

    public abstract String description();

    public abstract String getType();

    public abstract boolean getEtat() throws NonConnecteException;

    @Override
    public int compareTo(Composant o) {
        return o.getId().compareTo(this.getId());
    }
}
