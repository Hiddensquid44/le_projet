package composants;

import circuit.Circuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCircuits {
    static Composant[] tab=new Composant[7];

    public static void main(String[] args) throws NonConnecteException {
        Interrupteur interrupteur1=new Interrupteur();
        interrupteur1.on();
        Interrupteur interrupteur2=new Interrupteur();
        interrupteur2.off();
        Interrupteur interrupteur3=new Interrupteur();
        interrupteur3.on();
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

        test(circ);
        //TraceEtat(tab);

    }

    public static void TraceEtat(Composant[] tab) throws NonConnecteException {
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
            etat_Vanne=CalculateEtat(tab_travail[i]);
            System.out.println("La vanne numéro " + (i+1) + " est à l'état " + etat_Vanne);
        }
    }

    public static boolean CalculateEtat(Composant composant) throws NonConnecteException {
        boolean etat=false;
        try{
            etat = composant.getEtat();
        } catch (NonConnecteException e){
            e.printStackTrace();
        }
        return etat;
    }

    static void test(Circuit circ){
        System.out.println(circ.nomenclature());
        System.out.println("description");
        circ.description();
        System.out.println("Inputs");
        circ.getInputs();
        System.out.println("Outputs");
        circ.getOutputs();
    }
}