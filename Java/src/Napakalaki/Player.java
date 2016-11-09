package Napakalaki;

import java.util.ArrayList;

public class Player {
    //<<Constant>> ~MAXLEVEL : int = 10
    // Atributos
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<TreasureKind> visibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> hiddenTreasures = new ArrayList();
    
    // Constructor
    public Player( String name ) {
        // ISSUE::Implementar
    }
    
    // Metodos
    public String getName() {
        return name;
    }
    private void bringToLife() {
        dead = false;
    }
    private int getCombatLevel() {
        return level;
    }
    private void incrementLevels( int l ) {
        if( l > 0 )
            level += l;
    }
    private void decrementLevels( int l ) {
        if( l > 0 )
            level -= l;
    }
    private void setPendingBadConsequence( BadConsequence b ) {
        pendingBadConsequence = b;  
    }
    private void applyPrize( Monster m ) {
        // ISSUE::Implementar
    }
    private void applyBadConsequence( Monster m ) {
        // ISSUE::Implementar
    }
    
    private boolean canMakeTreasureVisible( Treasure t ) {
        // ISSUE::Implementar
    }
    private int howManyVisibleTreasures( TreasureKind tKind) {
        int count = 0;
        
        for ( int i = 0; i < visibleTreasures.size(); i++ )
            if ( visibleTreasures.get(i) == tKind )
                count++;
        
        return count;
    }
    private void dieIfNoTreasures() {
        if ( visibleTreasures.isEmpty() && hiddenTreasures.isEmpty() ) 
            dead = true;
    }
    public boolean isDead() {
        return dead;
    }
    public ArrayList getHiddenTreasures() {
        // ISSUE::Implementar
    }
    public ArrayList getVisibleTreasures() {
        // ISSUE::Implementar
    }
    public CombatResult combat( Monster m ) {
        // ISSUE::Implementar
    }
    public void makeTreasureVisible( Treasure t ) {
        // ISSUE::Implementar
    }
    public void discardVisibleTreasure( Treasure t ) {
        // ISSUE::Implementar
    }
    public void discardHiddenTreasure( Treasure t ) {
        // ISSUE::Implementar
    }
    public boolean validState() {
        boolean state = false;
        if ( !pendingBadConsequence.isEmpty() && hiddenTreasures.size() < 5 )
            state = true;
            
        return state;
    }
    public void initTreasures() {
        // ISSUE::Implementar
    }
    public int getLevels() {
        return level;
    }
    public Treasure stealTreasure() {
        // ISSUE::Implementar
    }
    public void setEnemy( Player enemy ) {
        this.enemy = enemy;
    }
    private Treasure giveMeATreasure() {
        // ISSUE::Implementar
    }
    public boolean canISteal() {
        return canISteal;
    }
    private boolean canYouGiveMeATreasure() {
        // ¿Los tesoros invisibles pueden ser robados?
        if ( visibleTreasures.isEmpty() )
            return false;
        else
            return true;
    }
    private void haveStolen() {
        canISteal = false;
    }
    public void discardAllTreasures() {
        // ISSUE::Implementar
    }
}
