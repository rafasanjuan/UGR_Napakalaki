package Napakalaki;

public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster( String name, int level, BadConsequence bc, Prize prize, int lC ){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badConsequence = bc;
        this.levelChangeAgainstCultistPlayer = lC;
    }
    
    // ISSUE::¿Hace falta conservar el antiguo constructor?
    public Monster( String name, int level, BadConsequence bc, Prize prize ){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badConsequence = bc;
        this.levelChangeAgainstCultistPlayer = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public int getCombatLevelAgainstCultistPlayer() {
        return ( combatLevel + levelChangeAgainstCultistPlayer );
    }
    
    public BadConsequence getBadConsequence() {
        return badConsequence;
    }
    
    public int getLevelsGained() {
        return prize.getLevels();
    }
    
    public int getTreasuresGained() {
        return prize.getTreasures();
    }
    
    @Override
    public String toString() {
        String monstruo = "";
        
        monstruo += this.name;
        monstruo += " ( Nivel: " + Integer.toString(combatLevel) + " )" + "\n";
        monstruo += "Recompensa: " + prize.toString() + "\n";
        monstruo += "Mal rollo: " + badConsequence.toString() + "\n";
        
        return monstruo;
    }
}
