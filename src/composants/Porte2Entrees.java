package composants;

/*
La classe Porte2Entrees est publique et abstraite. Elle descend de Composant.

Elle a 2 variables publiques et globales de type Composant qui correspondent aux 2 entrées des composants.
*/
public abstract class Porte2Entrees extends Porte{
    public Composant In1;
    public Composant In2;

    public Composant getIn1() {
        return In1;
    }

    public Composant getIn2() {
        return In2;
    }

    public void setIn1(Composant in1) {
        In1 = in1;
    }

    public void setIn2(Composant in2) {
        In2 = in2;
    }


    /*La méthode description() est publique.

    Elle renvoie un String qui décrit le composant de la façon suivante:
    Type_du_composant@ID avec la même description pour les 2 entrées du Composant
    (In1 : Type_du_composant_d_entree_1@ID_1 et In1 : Type_du_composant_d_entree_2@ID_2).
    Si, une entrée est vide, alors la fonction retourne "non connecte" pour cette entrée.
    */
    @Override
    public String description(){
        String str,str1,str2;
        if(In1==null) {
            str1 = "non connecte";
        }
        else{
            System.out.println(In1.getId());
            str1 = In1.getId();
        }
        if(In2==null) {
            str2 = "non connecte";
        }
        else{
            str2 = In2.getId();
        }
        str = getId() + " in1: " + str1 + " in2: " + str2;
        return str;
    }
}
