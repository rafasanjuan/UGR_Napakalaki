package Napakalaki;

//import java.util.*;

import java.util.Random;


public class CultistPlayer extends Player {
    private int totalCultistPlayers = 0;
    private Cultist myCultistCard;

    
    public CultistPlayer( Player p, Cultist c ) {
        super( p );
        this.myCultistCard = c;
        totalCultistPlayers++;
    }
    
    @Override
    public int getCombatLevel() {
        return (int) ( super.getCombatLevel() + (super.getCombatLevel() * 0.7) + 
                       this.myCultistCard.getGainedLevels() );
    }
    
    @Override
    protected int getOponentLevel( Monster m ) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert() {
        return false;
    }
    
    /*@Override
    private Treasure giveMeATreasure() {
        Random num = new Random();
        Treasure treasure = getHiddenTreasures().get( num.nextInt() % getHiddenTreasures().size() );
        getHiddenTreasures().remove(treasure);
        return treasure;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure() {
        return visibleTreasures.isEmpty();
    }*/
    
    public int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    @Override
    public void useJoker() {
        if ( joker_equipado )
        {
            joker_equipado = false;
            // Sobreescribimos con una nueva mala consequencia vacia.
            this.pendingBadConsequence = new NumericBadConsequence();
            super.discardJoker();
            
            // Si es cultista tambien pierde un tesoro visible
            if ( visibleTreasures.size() > 0 ) {
                int n_tesoro = (int) ( Math.random() * visibleTreasures.size()-1 + 1 );
                discardVisibleTreasure( visibleTreasures.get( n_tesoro ) );
            }
        }
    }
}
