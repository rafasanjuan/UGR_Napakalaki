package Napakalaki;

public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badConsequence = bc;
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
    
    public int getTreasuresGained() {
        return prize.getTreasures();
    }
    
    public String toString(){
        return "El nombre del monsturo = " + this.name + "\nPuntos de nivel = " + Integer.toString(combatLevel) + "\nPrize{" + prize.toString() + "}" + "\nBad Consequence{" + badConsequence.toString() + "}";
    }
    
}
