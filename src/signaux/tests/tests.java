package signaux.tests;

import signaux.*;

public class tests {

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

    public static void TestSignaux(SignalLogique s1, SignalLogique s2){
        System.out.println("Test d'un signal s1 : " + s1.toString() + " et d'un signal s2 : " + s2.toString());
        System.out.println("s1 and s2 : " + s1.and(s2).toString());
        System.out.println("s1 or s2 : " + s1.or(s2).toString());
        System.out.println("");
    }

    public static void TestSignal(SignalLogique s){
        System.out.println("Test du signal s : " + s.toString());
        System.out.println("s value : " + s.value());
        System.out.println("not s1 : " + s.not().toString());
        System.out.println("");
    }
}
