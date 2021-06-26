package composants;

import circuit.Circuit;
import signaux.SignalLogique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestCircuits {
    static Composant[] tab=new Composant[7];

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

        evaluate(circ);
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

    static void test(Circuit circ) throws NonConnecteException {
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

    static void evaluate(Circuit circ) throws NonConnecteException {
        circ.description();
        List<Interrupteur> inputs = circ.getInputs();
        for (Interrupteur in :
        inputs){
            Scanner userInput = new Scanner(System.in);
            String result = new String();
            while (!result.equals("1") && !result.equals("0")){
                System.out.println("Veuillez rentrer le niveau logique (0 ou 1) de l'interrupteur " + in.getId() + " : ");
                result = userInput.nextLine();
            }
            if (result.equals("1"))  in.on();
            else in.off();
            System.out.println("L'interrupteur " + in.getId() + " est à l'état " + in.evaluate().toString() + ".");
        }
        List<Vanne> outputs = circ.getOutputs();
        for (Vanne vanne :
                outputs) {
            SignalLogique vanneState = vanne.evaluate();
            if (vanneState.value())
                System.out.println("La vanne " + vanne.getId() + " est allumée.");
            else
                System.out.println("La vanne " + vanne.getId() + " est éteinte.");
        }
    }
}