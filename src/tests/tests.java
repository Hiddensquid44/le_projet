package tests;

import composants.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class tests {
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

    @Test
    public void TestInfoPorteNot() {
        And and = new And();
        Not not = new Not(and);
        String desc = not.description();
        System.out.println("TestInfoPorteNot : " + desc);
        String wanted = not.getId() + " in: " + and.getId();
        assertEquals(wanted, desc);
    }

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

    @Test
    public void TestGetEtatAnd() {
        Interrupteur int1 = new Interrupteur();
        Interrupteur int2 = new Interrupteur();
        int1.on;
        int2.off;
        And and = new And(int1, int2);
        Boolean etat = and.getEtat();
        System.out.println("TestGetEtatAnd : " + etat.toString());
        Boolean wanted = and.getEtat() + " in: " + and.getId();
        assertEquals(wanted, etat);
    }
}
