package Napakalaki;

import java.util.ArrayList;
import java.util.Collections;

public class CardDealer {
    // SINGLETON
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    
    // Constructor
    private CardDealer() {
        // ISSUE::Implementar
    }
    
    // Metodos
    private void initTreasureCardDeck() {
        // ISSUE::Implementar
    }
    
    private void initMonsterCardDeck() {
        // ISSUE::Implementar
    }
    
    private void shuffleTreasures() {
        Collections.shuffle( unusedTreasures );
    }
    
    private void shuffleMonsters() {
        Collections.shuffle( unusedMonsters );
    }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    public Treasure nextTreasure() {
        // ISSUE::Implementar
    }
          
    public Monster nextMonster() {
        // ISSUE::Implementar
    }
    
    public void giveTreasureBack( Treasure t ) {
        usedTreasures.add( t );
    }
    public void giveMonsterBack( Monster m){
        usedMonsters.add( m );
    }
    public void initCards() {
        // ISSUE::Implementar
    }
}
