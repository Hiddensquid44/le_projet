package composants;

import signaux.SignalLogique;


/*
La classe And est publique et descend de Porte2Entrees.

Il y a 2 types de constructeurs: Un qui permet de créer le composant sans paramètre et un qui permet
de le créer avec avec 2 entrées de type Composant.
*/
public class And extends Porte2Entrees{
    public And(Composant In1, Composant In2){
        if (In1!=null){
            setIn1(In1);
        }
        if (In2!=null){
            setIn2(In2);
        }
    }

    public And(){

    }

    /*
    La méthode getEtat est publique et renvoie un booleen.
    Dans le cas où une des 2 entrées n'est pas connectée, elle lance NonConnecteExeption.

    C'est une porte AND, donc si les 2 entrées sont à true, la sortie passe à true.
    Sinon, elle passe à false.
    */
    public boolean getEtat() throws NonConnecteException {
        boolean etat;
        if (In1 == null || In2 == null) {
            throw new NonConnecteException();
        }
        if (In1.getEtat()==true && In2.getEtat()==true){
            etat=true;
        }
        else{
            etat=false;
        }
        return etat;
    }

    /*
    La méthode getType est publique et renvoie un String.

    Elle renvoie, en chaine de caractère, le type de composant. Ici, "And".
    */
    public String getType() {
        return "And";
    }

    /*
    La méthode evaluate est publique et renvoie un SignalLogique.

    NIIIICCOOOLLLAASS
    */
    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        return In1.evaluate().and(In2.evaluate());
    }
}
