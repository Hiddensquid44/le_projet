package composants;

import signaux.SignalBas;
import signaux.SignalHaut;
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
    /*de la façon suivante: Type_du_composant@ID avec la même description pour
    la ou les entrées du composant (In : Type_du_composant_d_entree@ID ou
            In1 : Type_du_composant_d_entree_1@ID In2 : Type_du_composant_d_entree_2@ID)
    Si, l'entrée est vide, alors la fonction retourne "non connecté".
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

    public boolean getEtat() throws NonConnecteException {
        if (In == null) {
            throw new NonConnecteException();
        }
        return !In.getEtat();
    }


    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        if (In == null) {
            throw new NonConnecteException();
        }
        return In.evaluate().not();
    }

    public String getType() {
        return "Not";
    }
}
