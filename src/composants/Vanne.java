package composants;

import signaux.SignalLogique;

/*
La classe Vanne est publique. Elle descend de Composant.

Elle a 1 variables publiques et globales de type Composant qui correspondent à l'entrée du composant.

Il y a 2 types de constructeurs: Un qui permet de créer le composant sans paramètre et un qui permet
de le créer avec 2 entrées de type Composant.
*/
public class Vanne extends Composant {
    public Composant In;

    public Vanne(Composant In){
        this.In = In;
    }

    public Vanne(){

    }

    public Composant getIn() {
        return In;
    }

    public void setIn(Composant in) {
        In = in;
    }

    /*
    La méthode description est publique.

    Elle renvoie un String qui décrit le composant de la façon suivante:
    Type_du_composant@ID avec la même description pour l'entrée du Composant
    (In : Type_du_composant_d_entree@ID).
    Si, l'entrée est vide, alors la fonction retourne "non connecte".
    */
    @Override
    public String description() {
        String str, str1;
        if (In == null) {
            str1 = "non connecte";
        } else {
            str1 = In.getId();
        }
        str = getId() + " in: " + str1;
        return str;
    }

    /*
    La méthode getEtat est publique et renvoie un booleen.
    Dans le cas où l'entrée n'est pas connectée, elle lance NonConnecteExeption.

    C'est une Vanne, donc elle renvoie la même chose que son entrée.
    */
    @Override
    public boolean getEtat() throws NonConnecteException {
        if (In == null) {
            throw new NonConnecteException();
        }
        return In.getEtat();
    }

    /*
    La méthode getType est publique et renvoie un String.

    Elle renvoie, en chaine de caractère, le type de composant. Ici, "Vanne".
    */
    public String getType() {
        return "Vanne";
    }

    /*
    La méthode evaluate() est publique et renvoie un SignalLogique.

    Elle renvoie l'état logique de la vanne en fonction de l'état de son entrée.
    */
    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        return In.evaluate();
    }
}
