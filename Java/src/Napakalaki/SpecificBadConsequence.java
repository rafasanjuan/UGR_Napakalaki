package Napakalaki;
import java.util.*;

public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList(); 
    
    public SpecificBadConsequence( String text, int levels, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h ) {
        super( text, levels );
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure( Treasure t ) {
        specificVisibleTreasures.remove( t.getType() );
    }
    
    @Override
    public void substractHiddenTreasure( Treasure t ){
         specificHiddenTreasures.remove( t.getType() );
    }
    
    @Override
    public boolean isEmpty() {
        return ( specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty() );
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v , ArrayList<Treasure> h){
        BadConsequence local_bc = null;
        
        if(specificVisibleTreasures.size() > 0 || specificHiddenTreasures.size() > 0){
            ArrayList<TreasureKind> local_specificHiddenTreasures = new ArrayList();
            ArrayList<TreasureKind> local_specificVisibleTreasures = new ArrayList();
    
            for (Treasure v_treasure : v) {
                if(specificVisibleTreasures.contains(v_treasure.getType()))
                    local_specificVisibleTreasures.add(v_treasure.getType());
            }
            for (Treasure h_treasure : h) {
                if(specificHiddenTreasures.contains(h_treasure.getType()))
                    local_specificHiddenTreasures.add(h_treasure.getType());
            }
            local_bc = new SpecificBadConsequence( "", 0, local_specificVisibleTreasures, local_specificHiddenTreasures );
        }
        
        return local_bc;
    }
    
    @Override
    public String toString(){
        return this.text;    
    }
    
    String ListaTesoros() {
        String cadena = " ";
        for(TreasureKind t:specificVisibleTreasures){
            cadena = cadena + "\n" + t.toString();
        }
        return cadena;
    }
    
    String ListaTesorosOcultos() {
        String cadena = " ";
        for(TreasureKind t:specificHiddenTreasures){
            cadena = cadena + "\n" +t.toString();
        }
        return cadena;
    }
}