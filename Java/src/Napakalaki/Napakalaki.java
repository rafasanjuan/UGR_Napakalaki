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
    public CombatResult developCombat(){
        CombatResult combat = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        return combat;
    }
    public void discardVisibleTreasures( Treasure treasures[] ) {
        for (Treasure treasure : treasures) {
            //treasure = next(): Treasure (discardVisibleTreasures.pdf)
            currentPlayer.discardVisibleTreasure(treasure);
            CardDealer.getInstance().giveTreasureBack(treasure);
        }
    }
    public void discardHiddenTreasures( Treasure treasures[] ) {
        for(Treasure treasure : treasures){
           //treasure = next(): Treasure (discardVisibleTreasures.pdf)
           currentPlayer.discardHiddenTreasure(treasure);
           CardDealer.getInstance().giveTreasureBack(treasure);
        } 
    }
    
    public void makeTreasuresVisible( Treasure treasures[] ) {
        //t = next():Treasure(makeTreasuresVisible.pdf)
        for(Treasure treasure : treasures)
            currentPlayer.makeTreasureVisible(treasure);
    }
    
    public void initGame( String players[] ) {
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
