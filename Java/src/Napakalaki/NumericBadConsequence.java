package Napakalaki;
import java.util.*;

public class NumericBadConsequence extends BadConsequence {
    
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    
    public NumericBadConsequence( String test, int levels, int v, int h ) {
        super( test, levels );
        nVisibleTreasures = v;
        nHiddenTreasures = h;
    }

    public NumericBadConsequence() {
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
    }
		
		public int getNVisibleTreasures() {
			return nVisibleTreasures;
		}
		
		public int getNHiddenTreasures() {
			return nHiddenTreasures;
		}
    
    @Override
    public boolean isEmpty() {
        return ( nHiddenTreasures == 0 && nVisibleTreasures == 0 );
    }
    
    @Override
    public void substractVisibleTreasure( Treasure t ) {
			if ( nVisibleTreasures > 0 )
				nVisibleTreasures--;
    }
    
    @Override
    public void substractHiddenTreasure( Treasure t ) {
			if ( nHiddenTreasures > 0 )
				nHiddenTreasures--;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v , ArrayList<Treasure> h )
    {
        BadConsequence local_bc = null;
        
        if(nVisibleTreasures > 0 || nHiddenTreasures > 0){
            int local_nVisibleTreasures;
            int local_nHiddenTreasures;
            if(nVisibleTreasures < v.size())
                local_nVisibleTreasures = nVisibleTreasures;
            else
                local_nVisibleTreasures = v.size();
            
            if(nHiddenTreasures < h.size())
                local_nHiddenTreasures = nHiddenTreasures;
            else
                local_nHiddenTreasures = h.size();
            
            local_bc = new NumericBadConsequence("",0 , local_nVisibleTreasures, local_nHiddenTreasures);
        }
        
        return local_bc;
    }
    
    @Override
    public String toString(){
        return this.text;
    }
}
