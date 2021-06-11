package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class tests {
    @Test
    public void TestInfoPorteAnd() {
        Or or = new Or(null, null);
        Not not = new Not(null);
        And and = new And(or, not);
        String desc = and.description();
        System.out.println(desc);
        String wanted = "And@" + and.getId() + " in1: " + or.getId() + " in2: " + not.getId();
        assertEquals(desc, wanted);
    }
}
