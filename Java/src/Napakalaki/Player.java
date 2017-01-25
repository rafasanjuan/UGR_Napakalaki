package Napakalaki;
import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

public class Player {
    protected final static int MAXLEVEL = 10;
    
    // Atributos
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    
    // Constructor
    public Player( String name ) {
        this.name = name;
        this.level = 1;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
        this.pendingBadConsequence = new NumericBadConsequence();
        this.dead = true;
        this.canISteal = true;
        enemy = null;
    }
    
    public Player( Player p ) {
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.enemy = p.enemy;
        this.pendingBadConsequence = p.pendingBadConsequence;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
    }
    
    // Metodos
    public String getName() {
        return name;
    }
    
    private void bringToLife() {
        this.dead = false;
    }
    
    public int getCombatLevel() {
        int combat_level = level;
        
        for ( Treasure i : visibleTreasures )
            combat_level += i.getBonus();
        
        return combat_level;
    }
    
    private void incrementLevels( int l ) {
        if( l > 0 )
            level += l;
    }
    
    private void decrementLevels( int l ) {
        if( l > 0 )
            level -= l;
				
				if ( level < 1 )
					dead = true;
    }
    
    private void setPendingBadConsequence( BadConsequence b ) {
        pendingBadConsequence = b;  
    }
    
    public BadConsequence getPendingBadConsequence( ) {
        return pendingBadConsequence;  
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
			
        BadConsequence bq, pending_bq;
				bq = m.getBadConsequence();
			
				if ( bq instanceof DeathBadConsequence )
				{
					// No lo pone en el diagrama, pero si la bq es de muerte
					// el jugador debe morir para que haya represalias.
					this.dead = true;
					// Ademas tambien hago que pierda todos sus tesoros.
					this.visibleTreasures.clear();
					this.hiddenTreasures.clear();
					this.level = 1;
					this.canISteal = true;
					this.pendingBadConsequence = new NumericBadConsequence();
				}
				else 
				{
					int nLevels = bq.getLevels();
					decrementLevels( nLevels );

					pending_bq = bq.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
					setPendingBadConsequence( pending_bq );
				}
    }
    
    private boolean canMakeTreasureVisible( Treasure t ) {
			
			if ( t == null )
				return false;
				
        boolean canmakeVisible = true;
        int nmanos = 0;
        if(hiddenTreasures.contains(t)){
            for(int i=0; i < visibleTreasures.size() && canmakeVisible; i++){
                if(visibleTreasures.get(i).getType() != TreasureKind.ONEHAND){
                    if ( visibleTreasures.get(i).getType() == t.getType() ) {
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
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public CombatResult combat( Monster m ) 
    {
        CombatResult combat_result = null;
        
        int myLevel = this.getCombatLevel();
        int monsterLevel = getOponentLevel( m );
        
        if( !this.canISteal )
        {
            int number = Dice.getInstance().nextNumber();
            if(number < 3){
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel = monsterLevel + enemyLevel;
            }
        }
        
        if( myLevel > monsterLevel ) {
            this.applyPrize(m);
            if(this.level >= MAXLEVEL)
                combat_result = CombatResult.WINGAME;
            else
                combat_result = CombatResult.WIN;
        }
        else if(myLevel <= monsterLevel)
        {    
            if ( shouldConvert() )
            {
                combat_result = CombatResult.LOSEANDCONVERT;
                // ISSUE::¿Si se convierte recive las consecuencias?
                applyBadConsequence( m );
            }
            else
            {
                applyBadConsequence( m );
                combat_result = CombatResult.LOSE;
            }
        }
        return combat_result;        
    }
    
    public void makeTreasureVisible( Treasure t ) 
    {
        if( canMakeTreasureVisible( t ) )
        {
            if( hiddenTreasures.remove( t ) )
                
                visibleTreasures.add( t );   
        }
    }
    
    public void discardVisibleTreasure( Treasure t ) {
        visibleTreasures.remove(t);
        if ( pendingBadConsequence != null )
            pendingBadConsequence.substractVisibleTreasure(t);
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure( Treasure t ) {
				// Si lo tiene, lo borra, sino no pasa nada.  
				hiddenTreasures.remove( t );
				
				// Si el jugador tenia que descartarse un objeto de este tipo,
				// actualizamos la bad consequence para indicar que ya lo ha cumplido.
        if( pendingBadConsequence != null ) 
            pendingBadConsequence.substractHiddenTreasure( t );
				
				// Si el jugador se queda sin tesoros, muere.
        dieIfNoTreasures();
    }
    
    public boolean validState() {
        return ( pendingBadConsequence == null || 
               ( pendingBadConsequence.isEmpty() && hiddenTreasures.size() <= 4 ) 
               );
    }
    
    public void initTreasures() 
    {
        CardDealer dealer = CardDealer.getInstance();
        Dice dado = Dice.getInstance();
        
        bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
				
        int number = dado.nextNumber( "Girando el dado", "" );
        //int number = Dice.getInstance().nextNumber();
        
        if (number > 1) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if (number == 6) {
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
        
        if( canI && canYou ) {
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
        }
        return treasure;
    }
    
    public void setEnemy( Player enemy ) {
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure() {
        Treasure treasure = null;
        
        if ( !canYouGiveMeATreasure() )
        {
            Random num = new Random();
            treasure = hiddenTreasures.get( num.nextInt() % hiddenTreasures.size() );
            hiddenTreasures.remove( treasure );
        }
        
        return treasure;
    }
    
    public boolean canISteal() {
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure() {
        return hiddenTreasures.isEmpty();
    }
    
    private void haveStolen() {
        canISteal = false;
    }
    
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
    
    @Override
    public String toString(){
        return this.name;
    }
    
    protected boolean shouldConvert() {
        return ( Dice.getInstance().nextNumber() == 6 );
    }
    
    protected int getOponentLevel( Monster m ) {
        return m.getCombatLevel();
    }
    
    public Player getEnemy( ) {
        return this.enemy;
    }
    
    public void setHiddenTreasures( ArrayList<Treasure> list ) {
        this.hiddenTreasures = list;
    }
}
