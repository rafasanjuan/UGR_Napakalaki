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
    
    private Player nextPlayer()
    {
        int indice;
        
        if ( currentPlayer == null )
            
            indice = (int) ( Math.random() * players.size() + 0 );
        
        else
        {
             int indice_actual = players.indexOf( currentPlayer );
             
             if ( indice_actual == players.size() )
                 indice = 0;
             else
                 indice = indice_actual + 1;
        }
        currentPlayer = players.get( indice );
        
        return currentPlayer;
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
    public CombatResult developCombat()
    {
        CombatResult combat = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        
        if ( combat == CombatResult.LOSEANDCONVERT )
        {
            Cultist cultist_card = CardDealer.getInstance().nextCultist();
            CultistPlayer cultist_player = new CultistPlayer( currentPlayer, cultist_card );
            
            // Cambiamos el enemigo del resto de jugadores por el cultista
            for ( Player it : players ) 
            {
                if ( currentPlayer == it.getEnemy() )
                    it.setEnemy( cultist_player );
            }
            // Cambiamos el jugador actual por el cultista en la lista de jugadores.
            for ( Player it : players )
            {
                if ( it == currentPlayer )
                    it = cultist_player;
            }
            // Lo cambiamos en la variable jugador actual
            currentPlayer = cultist_player;
            
        }
        
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
        if ( stateOK )
        {
            this.currentMonster = CardDealer.getInstance().nextMonster();
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
