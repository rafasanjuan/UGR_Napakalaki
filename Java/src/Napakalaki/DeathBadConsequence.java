package Napakalaki;
//import java.util.*;

public class DeathBadConsequence extends NumericBadConsequence {
    
    private boolean death;
    
    public DeathBadConsequence( String text, boolean death ) {
        super( text, 0, 0, 0 );
        this.death = death;
    }
    
    @Override
    public String toString() {
        return "\nHas muerto.";
    }
}