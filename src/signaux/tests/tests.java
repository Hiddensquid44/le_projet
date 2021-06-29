package signaux.tests;

import signaux.*;

public class tests {

    /*
    La méthode main() crée 2 signaux bas et 2 signaux hauts.

    Elle appelle ensuite les méthodes de tests avec toutes les combinaisons de signaux possibles.
     */
    public static void main(String[] args){
        SignalBas bas_1 = new SignalBas();
        SignalBas bas_2 = new SignalBas();
        SignalHaut haut_1 = new SignalHaut();
        SignalHaut haut_2 = new SignalHaut();

        TestSignal(bas_1);
        TestSignal(haut_1);
        TestSignaux(bas_1, bas_2);
        TestSignaux(bas_1, haut_1);
        TestSignaux(haut_1, bas_1);
        TestSignaux(haut_1, haut_2);
    }

    /*
    TestSignaux est une méthode static et publique.

    Elle imprime dans le terminal le résultat des méthodes toString() des signaux s1 et s2,
    d'une porte and et d'une porte or avec ces mêmes signaux en entrée.
     */
    public static void TestSignaux(SignalLogique s1, SignalLogique s2){
        System.out.println("Test d'un signal s1 : " + s1.toString() + " et d'un signal s2 : " + s2.toString());
        System.out.println("s1 and s2 : " + s1.and(s2).toString());
        System.out.println("s1 or s2 : " + s1.or(s2).toString());
        System.out.println("");
    }

    /*
    TestSignal est une méthode static et publique.

    Elle imprime dans le terminal le résultat des méthodes toString() et value() du signal s
    et d'une porte not avec ce même signal en entrée.
     */
    public static void TestSignal(SignalLogique s){
        System.out.println("Test du signal s : " + s.toString());
        System.out.println("s value : " + s.value());
        System.out.println("not s1 : " + s.not().toString());
        System.out.println("");
    }
}
