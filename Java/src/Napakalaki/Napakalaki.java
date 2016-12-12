package Napakalaki;
import java.util.*;

public class Napakalaki {
    // SINGLETON
    private static final Napakalaki instance = new Napakalaki();
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Monster currentMonster; 
    
    private Napakalaki() {
        players = new ArrayList();
    }
    
    private void initPlayers( ArrayList<String> names ){
    
        for(int i= 0; i < names.size() ; i++){
            players.add( new Player(names.get(i)) );
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
        for (int i = 0; i < players.size(); i++){
            int actual;
            
            do {
                Random enemigo = new Random();
                actual = enemigo.nextInt(players.size());
            }while(actual == i);
            
            players.get(i).setEnemy( players.get(actual) );
        }
    }
    public static Napakalaki getInstance() {
        return instance;
    }
    public CombatResult developCombat(){
        CombatResult combat = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        return combat;
    }
    public void discardVisibleTreasures( ArrayList<Treasure> treasures ) {
        for (Treasure treasure : treasures) {
            //treasure = next(): Treasure (discardVisibleTreasures.pdf)
            currentPlayer.discardVisibleTreasure(treasure);
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
    }
    public void discardHiddenTreasures( ArrayList<Treasure> treasures ) {
        for(Treasure treasure : treasures){
           //treasure = next(): Treasure (discardVisibleTreasures.pdf)
           currentPlayer.discardHiddenTreasure(treasure);
           CardDealer.getInstance().giveTreasureBack(treasure);
        } 
    }
    
    public void makeTreasuresVisible( ArrayList<Treasure> treasures ) {
        //t = next():Treasure(makeTreasuresVisible.pdf)
        for(Treasure treasure : treasures)
            currentPlayer.makeTreasureVisible(treasure);
    }
    
    public void initGame( ArrayList<String> players ) {
        this.initPlayers(players);
        this.setEnemies();
        CardDealer.getInstance().initCards();
        this.nextTurn();
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    public boolean nextTurn() {
        boolean stateOK = this.nextTurnAllowed();
        if(stateOK){
            currentMonster = CardDealer.getInstance().nextMonster();
            this.currentPlayer = this.nextPlayer();
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();
            }
        }
    return stateOK;
    }
    public boolean endOfGame( CombatResult result ) {
        boolean endofgame = false;
        if(result == CombatResult.WINGAME)
            endofgame = true;
        return endofgame;
    }
    
}
