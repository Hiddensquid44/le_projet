package composants;

import signaux.SignalLogique;

/*
La classe Or est publique et descend de Porte2Entrees.

Il y a 2 types de constructeurs: Un qui permet de créer le composant sans paramètre et un qui permet
de le créer avec 2 entrées de type Composant.
*/
public class Or extends Porte2Entrees{
    public Or(Composant In1, Composant In2){
        if (In1!=null){
            setIn1(In1);
        }
        if (In2!=null){
            setIn2(In2);
        }
    }

    public Or()
    {

    }

    /*
    La méthode getEtat() est publique et renvoie un booléen.
    Dans le cas où une des 2 entrées n'est pas connectée, elle lance NonConnecteExeption.

    C'est une porte OR, donc si les 2 entrées sont à false (l.38), la sortie passe à false.
    Sinon, elle passe à true.
    */
    public boolean getEtat() throws NonConnecteException {
        boolean etat;
        if (In1 == null || In2 == null) {
            throw new NonConnecteException();
        }
        if (In1.getEtat()==false && In2.getEtat()==false){
            etat=false;
        }
        else{
            etat=true;
        }
        return etat;
    }

    /*
     La méthode getType() est publique et renvoie un String.

     Elle renvoie, en chaine de caractère, le type de composant. Ici, "Or".
     */
    public String getType() {
        return "Or";
    }

    /*
    La méthode evaluate() est publique.
    Dans le cas où une des 2 entrées n'est pas connectée, elle lance NonConnecteExeption.

    Elle renvoie le SignalLogique correspondant au résultat
    de la méthode or() appliquée sur ses 2 entrées.

    Elle remplace la méthode getEtat() qui devient obsolète dans la partie 4 du projet.
    */
    public SignalLogique evaluate() throws NonConnecteException
    {
        if (In1 == null || In2 == null) {
            throw new NonConnecteException();
        }
        return In1.evaluate().or(In2.evaluate());
    }


}
