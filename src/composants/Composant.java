package composants;

/*
La classe Composant est publique, abstraite et NIIIICOOLLLAAASSS

Toutes les classes qui descendent de Composant dovent contenir:

- Une méthode publique getId qui renvoie un String représentant l'ID du composant.

- Une méthode publique getType qui renvoie un String représentant le type du composant.

- Une méthode publique description qui renvoie un String qui décrit
le composant.

- Une méthode publique getEtat qui renvoie un booleen représentant l'état du composant
en fonction de ses entrées.

- NIIIICCCOOOLLAAASS

*/
public abstract class Composant implements Comparable <Composant>, Evaluable{
    public String getId(){
        return toString();
    }

    public abstract String getType();

    public abstract String description();

    public abstract boolean getEtat() throws NonConnecteException;

    @Override
    public int compareTo(Composant o) {
        return o.getId().compareTo(this.getId());
    }
}
