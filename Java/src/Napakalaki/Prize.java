package Napakalaki;

public class Prize {
    private int levels;
    private int treasures;
    
    public Prize( int lvl, int treasures ){
        this.levels = lvl;
        this.treasures = treasures;
    }
    
    public int getTreasures(){
        return treasures;
    }
    public int getLevels(){
        return levels;
    }
    /*
    void set_treasures(int treasures){
        this.treasures = treasures;
    }
    void set_levels(int levels){
        this.levels = levels;
    }
    
    public String toString(){
      return "Treasures = " + Integer.toString(treasures) + "levels = " + Integer.toString(levels);
    }
    */ 
}
