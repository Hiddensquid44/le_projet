package tests;

import composants.And;
import composants.Not;
import composants.Or;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class tests {
    @Test
    public void TestInfoPorteAnd() {
        Or or = new Or(null, null);
        Not not = new Not(null);
        And and = new And(or, null);
        String desc = and.description();
        System.out.println(desc);
        String wanted = and.getId() + " in1: " + or.getId() + " in2: non connecte";
        assertEquals(wanted, desc);
    }

    @Test
    public void TestInfoPorteOr() {
        Not not = new Not(null);
        And and = new And(null, null);
        Or or = new Or(not, null);
        String desc = or.description();
        System.out.println(desc);
        String wanted = or.getId() + " in1: " + not.getId() + " in2: non connecte";
        assertEquals(wanted, desc);
    }

    @Test
    public void TestInfoPorteNot() {
        And and = new And(null, null);
        Not not = new Not(and);
        String desc = not.description();
        System.out.println(desc);
        System.out.println(not.getId());
        String wanted = not.getId() + " in: " + and.getId();
        assertEquals(wanted, desc);
    }
}
