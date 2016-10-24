

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;
import java.util.ArrayList;
/**
 *
 * @author juanjomartin97
 */
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    BadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = new ArrayList();
        
    }
    BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
    }
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    String getText(){
        return text;
    }
    int getLevels(){
        return levels;
    }
    int GetVisibleTreasures(){
        return nVisibleTreasures;
    }
    int GetHiddenTreasures(){
        return nHiddenTreasures;
    }
    boolean GetDeath(){
        return death;
    }
    ArrayList GetSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    ArrayList GetSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    String ListaTesoros(){
        String cadena = " ";
        for(TreasureKind t:specificVisibleTreasures){
            cadena = cadena + t.toString();
        }
    return cadena;
    }
    
    public String toString(){
        return text + " Niveles perdidos = " + Integer.toString(levels) + " Tesoros perdidos" + Integer.toString(nVisibleTreasures) + ListaTesoros();
    }
    
}
