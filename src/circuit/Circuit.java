package circuit;

import composants.*;
import signaux.SignalLogique;

import java.util.*;

/*
La classe Circuit est publique.

Elle a 2 variables privées et globales :
- Une List de Composants
- Un String qui défini le nom.

Le constrcuteur permet de créer un Circuit avec un nom et une liste de Composants.
Il permet également de trier les composants selon leur ID.
*/
public class Circuit implements Evaluable{
    private List<Composant> composants=new ArrayList();
    private String nom;

    public List getComposants() {
        return composants;
    }

    public String getNom() {
        return nom;
    }

    public void setComposants(List composants) {
        this.composants = composants;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Circuit(String nom, Composant[] cps){
        setNom(nom);
        composants.addAll(Arrays.asList(cps));
        Collections.sort(composants);
    }

    /*
    La méthode nomenclature() est publique et renvoie une liste de String.

    Elle renvoie une liste des ID de tous les composants du circuit.
    */
    public List<String> nomenclature(){
        List idsComposants = new ArrayList();
        for (Composant composant: composants
             ) {
            idsComposants.add(composant.getId());
        }
        return idsComposants;
    }
    /*
    La méthode description() est publique et ne renvoie rien.

    Elle affiche le nom du circuit ainsi que la description de tous les composants du circuit.
    */
    public void description(){
        System.out.println("Nom du circuit : " + nom);
        System.out.println("Liste des composants : ");
        for (Composant composant: composants
             ) {
            System.out.println(composant.description());
        }
    }
    /*
    La méthode trace Etat() est publique et ne renvoie rien.

    Elle affiche le nom du circuit ainsi que l'ID de tous les composants avec leur Etat.
    */
    public void traceEtats() throws NonConnecteException {
        System.out.println("Nom du circuit : " + nom);
        System.out.println("Etat des composants : ");
        for (Composant composant: composants
        ) {
            System.out.println(composant.getId() + ":" + composant.getEtat());
        }
    }

    /*
    La méthode getInputs() est publique et renvoie une liste d'Interrupteurs.

    Elle renvoie une liste composée exclusivement des interrupteurs du circuit.
    */
    public List<Interrupteur> getInputs() {
        List<Interrupteur> inputs = new ArrayList();
        List<Composant> inputs_1 = new ArrayList<>();
        inputs_1.addAll(composants);
        inputs_1.removeIf(c -> c.getType() != "Interrupteur");  //Nous savons que c'est plus ou moins un "if" mais nous n'avons pas trouvé de meilleure solution
        for (Composant composant : inputs_1
        ) {
            inputs.add((Interrupteur)composant);
        }
            return inputs;
    }

    /*
    La méthode getOutputs() est publique et renvoie une liste de Vannes.

    Elle renvoie une liste composée exclusivement des vannes du circuit.
    */
    public List<Vanne> getOutputs(){
        List<Vanne> outputs=new ArrayList();
        List<Composant> outputs_1 = new ArrayList<>();
        outputs_1.addAll(composants);
        outputs_1.removeIf(c -> c.getType() != "Vanne");    //Nous savons que c'est plus ou moins un "if" mais nous n'avons pas trouvé de meilleure solution
        for (Composant composant : outputs_1
        ) {
            outputs.add((Vanne)composant);
        }
        return outputs;
    }

    @Override
    public SignalLogique evaluate() throws NonConnecteException {
        this.description();
        List<Interrupteur> inputs = this.getInputs();
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
        List<Vanne> outputs = this.getOutputs();
        for (Vanne vanne :
                outputs) {
            SignalLogique vanneState = vanne.evaluate();
            if (vanneState.value())
                System.out.println("La vanne " + vanne.getId() + " est allumée.");
            else
                System.out.println("La vanne " + vanne.getId() + " est éteinte.");
        }
        return null;
    }
}
