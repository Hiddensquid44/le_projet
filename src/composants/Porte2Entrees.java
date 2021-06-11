package composants;

public abstract class Porte2Entrees extends Porte{
    public Composant In1;
    public Composant In2;

    public Composant getIn1() {
        return In1;
    }

    public Composant getIn2() {
        return In2;
    }

    public void setIn1(Composant in1) {
        In1 = in1;
    }

    public void setIn2(Composant in2) {
        In2 = in2;
    }

    public abstract String getType();

    public String description(){
        String str,str1,str2;
        if(In1==null) {
            str1 = "non connecte";
        }
        else{
            str1 = In1.getID();
        }
        if(In2==null) {
            str2 = "non connecte";
        }
        else{
            str2 = In2.getID();
        }
        str = getType() + "@" + getID() + " In1 : " + str1 + " In2 : " + str2;
        return str;
    }
}
