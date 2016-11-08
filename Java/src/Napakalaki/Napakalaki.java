package Napakalaki;

public class Napakalaki {
    // SINGLETON
    private static final Napakalaki instance = new Napakalaki();
    
    private Napakalaki() {
        // ISSUE::Implementar
    }
    
    private void initPlayers( String names[] ){
        // ISSUE::Implementar
    }
    private Player nextPlayer(){
        // ISSUE::Implementar
    }
    private boolean nextTurnAllowed(){
        // ISSUE::Implementar
    }
    private void setEnemies(){
        // ISSUE::Implementar
    }
    public static Napakalaki getInstance() {
        return instance;
    }
    public CombatResult developCombat(){
        // ISSUE::Implementar
    }
    public void discardVisibleTreasures( Treasure treasures[] ) {
        // ISSUE::Implementar
    }
    public void discardHiddenTreasures( Treasure treasures[] ) {
        // ISSUE::Implementar
    }
    public void makeTreasuresVisible( Treasure treasures[] ) {
        // ISSUE::Implementar
    }
    public void initGame( String players[] ) {
        // ISSUE::Implementar
    }
    public Player getCurrentPlayer() {
        // ISSUE::Implementar
    }
    public Monster getCurrentMonster() {
        // ISSUE::Implementar
    }
    public boolean nextTurn() {
        // ISSUE::Implementar
    }
    public boolean endOfGame( CombatResult relult ) {
        // ISSUE::Implementar
    }
    
}
