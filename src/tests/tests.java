package tests;

import composants.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class tests {

    /*
    TestInfoPorteAnd est une méthode de test publique.

    Elle test la fonction description d'une porte And, imprime le résultat dans le terminal
    et lance une erreur si le résultat n'est pas celui attendu.
     */
    @Test
    public void TestInfoPorteAnd() {
        Or or = new Or();
        And and = new And();
        and.setIn1(or);
        String desc = and.description();
        System.out.println("TestInfoPorteAnd : " + desc);
        String wanted = and.getId() + " in1: " + or.getId() + " in2: non connecte";
        assertEquals(wanted, desc);
    }

    /*
    TestInfoPorteOr est une méthode de test publique.

    Elle test la méthode description() d'une porte Or, imprime le résultat dans le terminal
    et lance une erreur si le résultat n'est pas celui attendu.
     */
    @Test
    public void TestInfoPorteOr() {
        Not not = new Not();
        Or or = new Or();
        or.setIn1(not);
        String desc = or.description();
        System.out.println("TestInfoPorteOr : " + desc);
        String wanted = or.getId() + " in1: " + not.getId() + " in2: non connecte";
        assertEquals(wanted, desc);
    }

    /*
    TestInfoPorteNot est une méthode de test publique.

    Elle test la méthode description() d'une porte Not, imprime le résultat dans le terminal
    et lance une erreur si le résultat n'est pas celui attendu.
     */
    @Test
    public void TestInfoPorteNot() {
        And and = new And();
        Not not = new Not(and);
        String desc = not.description();
        System.out.println("TestInfoPorteNot : " + desc);
        String wanted = not.getId() + " in: " + and.getId();
        assertEquals(wanted, desc);
    }

    /*
    TestInfoPorteVanne est une méthode de test publique.

    Elle test la méthode description() d'une porte Vanne, imprime le résultat dans le terminal
    et lance une erreur si le résultat n'est pas celui attendu.
     */
    @Test
    public void TestInfoVanne() {
        And and = new And();
        Not not = new Not();
        Vanne vanne = new Vanne(and);
        String desc = vanne.description();
        System.out.println("TestInfoVanne : " + desc);
        String wanted = vanne.getId() + " in: " + and.getId();
        assertEquals(wanted, desc);
    }

    /*
    TestGetEtatPorteAnd est une méthode de test publique.

    Elle test la méthode getEtat() d'une porte And en essayant toutes les combinaisons
    d'entrées possibles, imprime le résultat dans le terminal
    et lance une erreur si le résultat n'est pas celui attendu.
     */
    @Test
    public void TestGetEtatAnd(){
        Boolean etatAnd=false;
        Interrupteur int1 = new Interrupteur();
        Interrupteur int2 = new Interrupteur();
        And and = new And();
        and.setIn1(int1);
        and.setIn2(int2);
        System.out.println("TestGetEtatAnd : ");
        System.out.println("");

        try {
            int1.off();
            int2.off();
            etatAnd = and.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatAnd.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(false, etatAnd);

        try {
            int1.on();
            int2.off();
            etatAnd = and.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatAnd.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(false, etatAnd);

        try {
            int1.off();
            int2.on();
            etatAnd = and.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatAnd.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(false, etatAnd);

        try {
            int1.on();
            int2.on();
            etatAnd = and.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatAnd.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(true, etatAnd);


        System.out.println("");
        System.out.println("");
    }

    /*
    TestGetEtatPorteOr est une méthode de test publique.

    Elle test la méthode getEtat() d'une porte Or en essayant toutes les combinaisons
    d'entrées possibles, imprime le résultat dans le terminal
    et lance une erreur si le résultat n'est pas celui attendu.
     */
    @Test
    public void TestGetEtatOr(){
        Boolean etatOr=false;
        Interrupteur int1 = new Interrupteur();
        Interrupteur int2 = new Interrupteur();
        Or or = new Or();
        or.setIn1(int1);
        or.setIn2(int2);
        System.out.println("TestGetEtatOr : ");
        System.out.println("");

        try {
            int1.off();
            int2.off();
            etatOr = or.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatOr.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(false, etatOr);

        try {
            int1.on();
            int2.off();
            etatOr = or.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatOr.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(true, etatOr);

        try {
            int1.off();
            int2.on();
            etatOr = or.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatOr.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(true, etatOr);

        try {
            int1.on();
            int2.on();
            etatOr = or.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nIn2 : " + int2.getEtat() + "\nEtat : " + etatOr.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(true, etatOr);
        System.out.println("");
        System.out.println("");
    }

    /*
    TestGetEtatPorteNot est une méthode de test publique.

    Elle test la méthode getEtat() d'une porte Not en essayant toutes les combinaisons
    d'entrées possibles, imprime le résultat dans le terminal
    et lance une erreur si le résultat n'est pas celui attendu.
     */
    @Test
    public void TestGetEtatNot(){
        Boolean etatNot=true;
        Interrupteur int1 = new Interrupteur();
        Not not = new Not();
        System.out.println("TestGetEtatNot : ");
        System.out.println("");

        try {
            int1.on();
            not.setIn(int1);
            etatNot = not.getEtat();
            System.out.println("In : " + int1.getEtat() + "\nEtat : " + etatNot.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(false, etatNot);

        try {
            int1.off();
            not.setIn(int1);
            etatNot = not.getEtat();
            System.out.println("In1 : " + int1.getEtat() + "\nEtat : " + etatNot.toString());
            System.out.println("");
        }catch(NonConnecteException e){
            e.printStackTrace();
        }
        assertEquals(true, etatNot);
        System.out.println("");
        System.out.println("");
    }

    /*
    Si vous lisez ces lignes,
    Je ne vous fait pas l'affront de commenter ce test, bien que l'envie y soit.
    Bon courage !
     */
    @Test
    public void CeNestPasLeSeulTest()
    {
        System.out.println("Comme demandé dans le sujet, 2 programmes de tests contenant des main sont présents dans les packages \"composants\" et \"signaux\".");
    }
}
