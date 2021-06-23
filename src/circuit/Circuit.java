package circuit;

import composants.*;

import java.util.*;

public class Circuit {
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

    public List<String> nomenclature(){
        List idsComposants = new ArrayList();
        for (Composant composant: composants
             ) {
            idsComposants.add(composant.getId());
        }
        return idsComposants;
    }

    public void description(){
        System.out.println("Nom du circuit : " + nom);
        System.out.println("Liste des composants : ");
        for (Composant composant: composants
             ) {
            System.out.println(composant.description());
        }
    }

    public void traceEtats() throws NonConnecteException {
        System.out.println("Nom du circuit : " + nom);
        System.out.println("Etat des composants : ");
        for (Composant composant: composants
        ) {
            System.out.println(composant.getId() + ":" + composant.getEtat());
        }
    }

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
}
