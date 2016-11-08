package Napakalaki;

public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.badConsequence = bc;
        this.prize = prize;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
    
    public int getLevelsGained(){
        return prize.getLevels();
    }
    /*
    public String toString(){
        return "El nombre del monsturo = " + name + "Puntos de nivel = " + Integer.toString(combatLevel) + prize.toString() + bad_consequence.toString();
    }
    */
}
