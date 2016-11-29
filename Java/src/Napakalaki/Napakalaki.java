package Napakalaki;
import java.util.ArrayList;

public class Napakalaki {
    // SINGLETON
    private static final Napakalaki instance = new Napakalaki();
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Monster currentMonster; 
    
    private Napakalaki() {
        // ISSUE::Implementar
    }
    
    private void initPlayers( String names[] ){
        int i;
        for(i= 0; i < names.length ; i++){
            Player local= new Player(names[i]);
            players.add(local);
        }
        
    }
    private Player nextPlayer(){
        int numeroAleatorio = (int) ( Math.random() % players.size() );
        Player local;
        if(currentPlayer == null){
            local = players.get(numeroAleatorio);
        }
        else{
            local = players.get(players.indexOf(currentPlayer) + 1);
            
        }
    return local;
    }
    private boolean nextTurnAllowed(){
        boolean valido = true;
        if(currentPlayer != null && currentPlayer.validState() == false){
            valido = false;
        }
    return valido;
    }
    private void setEnemies(){
        Player enemy;
        do{
        int numeroAleatorio = (int) ( Math.random() * players.size() + 1 );
        enemy = players.get(numeroAleatorio);
        }while(enemy == currentPlayer);
        currentPlayer.setEnemy(enemy);
    }
    public static Napakalaki getInstance() {
        return instance;
    }
    /*public CombatResult developCombat(){
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
        return currentPlayer;
    }
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    public boolean nextTurn() {
        // ISSUE::Implementar
    }*/
    public boolean endOfGame( CombatResult result ) {
        boolean endofgame = false;
        if(result == CombatResult.WINGAME)
            endofgame = true;
    return endofgame;
    }
    
}
