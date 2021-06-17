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
        /*for (Composant composant : composants
        ) {
            inputs.add((Interrupteur) composant);
        }*/
            return inputs;
    }

    public List<Vanne> getOutputs(){
        List<Vanne> outputs=new ArrayList();
        for (Composant composant : composants
        ) {
            outputs.add((Vanne) composant);
        }
        return outputs;
    }
}
