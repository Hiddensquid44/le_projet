package circuit;

import composants.*;
import java.util.List;
    /*
    TestCircuits est une classe publique.

    Elle permet de tester les méthodes de la classe Circuit.
     */
public class TestCircuits {
    static Composant[] tab=new Composant[7];

    /*
    La fonction principale est publique, statique et ne retourne rien.

    Elle permet de créer un circuit:
    - Créer les composants
    - Remplir le tableau
    Puis, elle permet de tester la méthode evaluate() avec ce Circuit.

    Attention, si vous voulez tester un circuit différent,
    veuillez vérifier la taille du tableau Composant ci-dessus.
     */
    public static void main(String[] args) throws NonConnecteException {
        Interrupteur interrupteur1=new Interrupteur();
        Interrupteur interrupteur2=new Interrupteur();
        Interrupteur interrupteur3=new Interrupteur();
        Or or=new Or(interrupteur1,interrupteur2);
        Not not=new Not(interrupteur3);
        And and=new And(or,not);
        Vanne vanne=new Vanne(and);

        tab[0]=or;
        tab[1]=and;
        tab[4]=vanne;
        tab[2]=interrupteur1;
        tab[3]=interrupteur2;
        tab[6]=interrupteur3;
        tab[5]=not;
        Circuit circ = new Circuit("TEST",tab);

        circ.evaluate();
        test(circ);
        //traceEtat(tab);

    }

    /*
    traceEtat est une méthode publique et statique.

    Elle n'est plus utilisée depuis que la méthode evaluate() de la classe Ciruit l'a remplacée.

    Elle récupère les Vannes du circuit passé en paramètre, calcule l'état de chaque Vanne
    et imprime le résultat dans le terminal.
     */
    public static void traceEtat(Composant[] tab) throws NonConnecteException {
        Composant[] tab_travail=new Composant[tab.length], tab_copy=tab;
        boolean etat_Vanne=true;
        int j=0;
        for(int i= 0;i < tab_copy.length;i++){
            if (tab_copy[i].getType().equals("Vanne")){
                tab_travail[j]=tab_copy[i];
                j++;
                for (int k=i; k < tab_copy.length - 1; k++){
                    tab_copy[k]=tab_copy[k+1];
                }
            }
        }
        for(int i = 0;i < tab_copy.length-j;i++){
            tab_travail[j+i]=tab_copy[i];
        }
        for(int i=0;i<j;i++){
            etat_Vanne=calculateEtat(tab_travail[i]);
            System.out.println("La vanne numéro " + (i+1) + " est à l'état " + etat_Vanne);
        }
    }

    /*
    calculateEtat est une méthode publique et statique qui renvoie un booléen.

    Elle n'est plus utilisée depuis que la méthode evaluate() a remplacé la méthode traceEtat().

    Elle calcule l'état d'un composant en utilisant sa méthode getEtat() et le retourne (booléen).
    Si elle attrape une exception du type NonConnecteException,
    elle imprime la trace de l'erreur dans le terminal.
     */
    public static boolean calculateEtat(Composant composant) throws NonConnecteException {
        boolean etat=false;
        try{
            etat = composant.getEtat();
        } catch (NonConnecteException e){
            e.printStackTrace();
        }
        return etat;
    }

    /*
    test() est une méthode statique qui ne renvoie rien.

    Elle imprime dans le terminal les méthode nomenclature(), description(), getInputs(), getOutputs()
    et traceEtat() de la classe circuit.
     */
    static void test(Circuit circ) throws NonConnecteException {

        System.out.println("");
        System.out.println("");
        System.out.println("MÉTHODE TEST :");
        System.out.println("nomenclature :");
        System.out.println(circ.nomenclature());
        System.out.println("description :");
        circ.description();
        System.out.println("Inputs :");
        List<Interrupteur> inputs = circ.getInputs();
        for (Interrupteur interrupteur :
                inputs) {
            System.out.println(interrupteur.getId());
        }
        System.out.println("Outputs :");
        List<Vanne> outputs = circ.getOutputs();
        for (Vanne vanne :
                outputs) {
            System.out.println(vanne.getId());
        }
        System.out.println("");
        System.out.println("On force l'interrupteur 1 à faux.");
        inputs.get(0).off();
        System.out.println("TraceEtat :");
        circ.traceEtats();
    }
}