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
    private final ArrayList<Treasure> visibleTreasures = new ArrayList();
    private final ArrayList<Treasure> hiddenTreasures = new ArrayList();
    
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
        boolean canmakeVisible = true;
        int nmanos = 0;
        if(hiddenTreasures.contains(t)){
            for(int i=0; i < visibleTreasures.size() && canmakeVisible; i++){
                if(visibleTreasures.get(i).getType() != TreasureKind.ONEHAND){
                    if(visibleTreasures.get(i).getType() == t.getType()){
                        canmakeVisible = false;
                    }
                }
                else{
                    nmanos++;
                    if(t.getType() == TreasureKind.BOTHHANDS)
                        canmakeVisible = false;
                }
                if(nmanos == 2 && t.getType() == TreasureKind.ONEHAND)
                    canmakeVisible = false;
                if(visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS && t.getType() == TreasureKind.ONEHAND)
                    canmakeVisible = false;
            }
        }
        else{
            canmakeVisible = false;
        }
    return canmakeVisible;    
    }
    private int howManyVisibleTreasures( TreasureKind tKind) {
        int count = 0;
        
        for ( int i = 0; i < visibleTreasures.size(); i++ )
            if ( visibleTreasures.get(i).getType() == tKind )
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
        int numeroAleatorio = (int) ( Math.random() * hiddenTreasures.size() + 1 );
        return hiddenTreasures.get(numeroAleatorio);
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
