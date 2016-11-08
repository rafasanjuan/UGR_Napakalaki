package Napakalaki;
import java.util.ArrayList;

public class BadConsequence {
    /* Atributos */
    private static int MAXTREASURES = 10;
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
        // ISSUE::Implementar
    }
    
    public void substractVisibleTreasure( Treasure t ) {
        // ISSUE::Implementar
    }
    
    public void substractHiddenTreasure( Treasure t ) {
        // ISSUE::Implementar
    }
    
    public String toString(){
        return text + " Niveles perdidos = " + Integer.toString(levels) + " Tesoros perdidos" + Integer.toString(nVisibleTreasures) + ListaTesoros();
    }
    
    public BadConsequence adjustToFitTreasureLists ( Treasure v[], Treasure h[]) {
        // ISSUE::Implementar
    }
}
