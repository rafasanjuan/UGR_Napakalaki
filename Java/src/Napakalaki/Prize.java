/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author juanjomartin97
 */
public class Prize {
    private int levels;
    private int treasures;
    
    Prize(int lvl, int treasures){
        set_levels(lvl);
        set_treasures(treasures);
    }
    
    int get_treasures(){
        return treasures;
    }
    int get_levels(){
        return levels;
    }
    void set_treasures(int treasures){
        this.treasures = treasures;
    }
    void set_levels(int levels){
        this.levels = levels;
    }
    
    public String toString(){
      return "Treasures = " + Integer.toString(treasures) + "levels = " + Integer.toString(levels);
    }
    
    
}
