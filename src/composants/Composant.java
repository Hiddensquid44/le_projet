package composants;

/*
La classe Composant est publique, abstraite et NIIIICOOLLLAAASSS

Toutes les classes qui descendent de Composant dovent contenir:

- Une fonction publique getId qui renvoie un String représentant l'ID du composant.
- Une fonction publique et abstraite description qui renvoie un String représentant l'ID du composant.

*/
public abstract class Composant implements Comparable <Composant>, Evaluable{
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
