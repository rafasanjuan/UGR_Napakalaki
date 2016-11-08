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
    
    // Constructor
    public Player( String name ) {
        // ISSUE::Implementar
    }
    
    // Metodos
    public String getName() {
        return name;
    }
    private void bringToLife() {
        // ISSUE::Implementar
    }
    private int getCombatLevel() {
        return level;
    }
    private void incrementLevels( int l ) {
        // ISSUE::Implementar
    }
    private void decrementLevels( int l ) {
        // ISSUE::Implementar
    }
    private void setPendingBadConsequence( BadConsequence b ) {
        // ISSUE::Implementar
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
        // ISSUE::Implementar
    }
    private void dieIfNoTreasures() {
        // ISSUE::Implementar
    }
    public boolean isDead() {
        // ISSUE::Implementar
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
        // ISSUE::Implementar
    }
    public void initTreasures() {
        // ISSUE::Implementar
    }
    public int getLevels() {
        // ISSUE::Implementar
    }
    public Treasure stealTreasure() {
        // ISSUE::Implementar
    }
    public void setEnemy( Player enemy ) {
        // ISSUE::Implementar
    }
    private Treasure giveMeATreasure() {
        // ISSUE::Implementar
    }
    public boolean canISteal() {
        // ISSUE::Implementar
    }
    private boolean canYouGiveMeATreasure() {
        // ISSUE::Implementar
    }
    private void haveStolen() {
        // ISSUE::Implementar
    }
    public void discardAllTreasures() {
        // ISSUE::Implementar
    }
}
