package Napakalaki;

import java.util.ArrayList;

public class Player {
    protected final int MAXLEVEL = 10;
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
        int nLevels = m.getLevelsGained();
        int nTreasures = m.getTreasuresGained();
        
        this.incrementLevels(nLevels);
        if(nTreasures > 0){
            int i;
            for(i = 0; i < nTreasures; i++){
                Treasure treasure = CardDealer.getInstance().nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence( Monster m ) {
        BadConsequence bad_consequence = m.getBadConsequence();
        int nLevels = bad_consequence.getLevels();
        this.decrementLevels(nLevels);
        BadConsequence pendingBad;

        pendingBad = bad_consequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures); //puede que error en llamada o cabecera
        this.setPendingBadConsequence(pendingBad);
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
        else
            canmakeVisible = false;
        
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
        return hiddenTreasures;
    }
    
    public ArrayList getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public CombatResult combat( Monster m ) {
        CombatResult combatresult;
        int myLevel = this.getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        if(!this.canISteal){ //Atribute or function??
            int number = Dice.getInstance().nextNumber();
            if(number < 3){
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel = monsterLevel + enemyLevel;
            }
        }
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            if(this.level >= MAXLEVEL)
                combatresult = CombatResult.WINGAME;
            else
                combatresult = CombatResult.WIN;
        }
        else{
            this.applyBadConsequence(m);
            combatresult = CombatResult.LOSE;
        }
    return combatresult;        
    }
    
    public void makeTreasureVisible( Treasure t ) {
        
        if(canMakeTreasureVisible(t)){
            if( hiddenTreasures.remove(t))
                visibleTreasures.add(t);   
        }
    }
    
    public void discardVisibleTreasure( Treasure t ) {
        visibleTreasures.remove(t);
        if(pendingBadConsequence != null && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure( Treasure t ) {
        hiddenTreasures.remove(t);
        if(pendingBadConsequence != null && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    
    public boolean validState() {
        boolean state = false;
        if ( !pendingBadConsequence.isEmpty() && hiddenTreasures.size() < 5 )
            state = true;
            
        return state;
    }
    
    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        this.bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
       
        int number = dice.nextNumber();
        
        if(number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels() {
        return level;
    }
    
    public Treasure stealTreasure() {
        boolean canI = this.canISteal;
        boolean canYou = enemy.canYouGiveMeATreasure();
        Treasure treasure = null;
        
        if(canI){
            if(canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }
    return treasure;
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
    
    /* void discardAllTreasures() {
        visibleTreasures.forEach((visibleTreasure) -> {
            this.discardVisibleTreasure(visibleTreasure);
        });
        hiddenTreasures.forEach((hiddenTreasure) -> {
            this.discardHiddenTreasure(hiddenTreasure);
        });
    }*/
    public void discardAllTreasures(){
        ArrayList<Treasure> local_visible_treasures = new ArrayList<>(visibleTreasures);
        ArrayList<Treasure> local_hidden_treasures = new ArrayList<> (hiddenTreasures);
        
        local_visible_treasures.forEach((treasure) -> {
            discardVisibleTreasure(treasure);
        });
        local_hidden_treasures.forEach((treasure) -> {
            discardHiddenTreasure(treasure);
        });
       
    }
}
