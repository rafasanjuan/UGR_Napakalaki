package Napakalaki;
import java.util.ArrayList;

public class BadConsequence {
    /* Atributos */
    protected static int MAXTREASURES = 10;
    private String text = "";
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    /* Constructores */
    BadConsequence( String text, int levels, int nVisibleTreasures, int nHiddenTreasures ){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = new ArrayList();
        
    }
    BadConsequence( String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden ){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    BadConsequence( String text, boolean death ){
        this.text = text;
        this.death = death;
    }
    
    /* Metodos de acceso a variables */
    String getText(){
        return text;
    }
    int getLevels(){
        return levels;
    }
    int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    boolean GetDeath(){
        return death;
    }
    ArrayList getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    ArrayList getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    String ListaTesoros(){
        String cadena = " ";
        for(TreasureKind t:specificVisibleTreasures){
            cadena = cadena + t.toString();
        }
    return cadena;
    }
    
    /* Otros metodos */ 
    public boolean isEmpty() {
        boolean empty;
        
        empty = nVisibleTreasures == 0 && nHiddenTreasures == 0 &&
                levels == 0 && death == false &&
                specificHiddenTreasures.isEmpty() &&
                specificVisibleTreasures.isEmpty();
        
        return empty;
    }
    
    public void substractVisibleTreasure( Treasure t ) {
        if(nVisibleTreasures == 0)
            specificVisibleTreasures.remove(t.getType());
        else
            nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure( Treasure t ) {
        if(nHiddenTreasures == 0)
            specificHiddenTreasures.remove(t.getType());
        else
            nHiddenTreasures--;
    }
    
    public String toString(){
        return text + " Niveles perdidos = " + Integer.toString(levels) + " Tesoros perdidos" + Integer.toString(nVisibleTreasures) + ListaTesoros();
    }
    
    public BadConsequence adjustToFitTreasureLists ( ArrayList<Treasure> v, ArrayList<Treasure> h) { //comprobar cabecera
        BadConsequence local_bc = new BadConsequence("",false);
        
        if(nVisibleTreasures > 0 || nHiddenTreasures > 0){
            if(nVisibleTreasures < v.size())
                local_bc.nVisibleTreasures = nVisibleTreasures;
            else
                local_bc.nVisibleTreasures = v.size();
            
            if(nHiddenTreasures < h.size())
                local_bc.nHiddenTreasures = nHiddenTreasures;
            else
                local_bc.nHiddenTreasures = h.size();
        }
        else if(specificVisibleTreasures.size() > 0 || specificHiddenTreasures.size() > 0){
            for (Treasure v_treasure : v) {
                if(specificVisibleTreasures.contains(v_treasure.getType()))
                    local_bc.specificVisibleTreasures.add(v_treasure.getType());
            }
            for (Treasure h_treasure : h) {
                if(specificHiddenTreasures.contains(h_treasure.getType()))
                    local_bc.specificHiddenTreasures.add(h_treasure.getType());
            }
        }
    return local_bc;
    }

  
}
