package composants;

import signaux.SignalLogique;

/*
La classe Not est publique et descend de Porte.

Il y a 2 types de constructeurs: Un qui permet de créer le composant sans paramètre et un qui permet
de le créer avec avec 1 entrée de type Composant.
*/
public class Not extends Porte{
    public Composant In;

    public Composant getIn() {
        return In;
    }

    public void setIn(Composant in) {
        In = in;
    }

    public Not(Composant In) {
        if (In != null) {
            setIn(In);
        }
    }

    public Not() {

    }
    /*
    La méthode description est publique.

    Elle renvoie un String qui décrit le composant de la façon suivante:
    Type_du_composant@ID avec la même description pour l'entrée du Composant
    (In : Type_du_composant_d_entree@ID).
    Si l'entrée est vide, alors la fonction retourne "non connecte".
    */
    @Override
    public String description(){
        String str,str1;
        if(In==null) {
            str1 = "non connecte";
        }
        else{
            str1 = In.getId();
        }
        str = getId() + " in: " + str1;
        return str;
    }
    /*
    La méthode getEtat est publique et renvoie un booleen.
    Dans le cas où l'entrée n'est pas connectée, elle lance NonConnecteExeption.

    C'est une porte NOT, donc elle renvoie l'inverse de l'entrée.
    */
    public boolean getEtat() throws NonConnecteException {
        if (In == null) {
            throw new NonConnecteException();
        }
        return !In.getEtat();
    }

    /*
    La méthode evaluate() est publique et renvoie un SignalLogique.
    Si l'entrée est vide, NonConnecteExeption est déclenché.

    Elle renvoie l'état logique de la porte NOT en fonction de l'état de son entrée.
    */
    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        if (In == null) {
            throw new NonConnecteException();
        }
        return In.evaluate().not();
    }
    /*
    La méthode getType est publique et renvoie un String.

    Elle renvoie, en chaine de caractère, le type de composant. Ici, "Not".
    */
    public String getType() {
        return "Not";
    }
}
