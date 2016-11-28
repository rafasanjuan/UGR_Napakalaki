#encoding: UTF-8

class Napakalaki
  
  require "singleton"
  
  attr_accesor :currentPlayer, :players, :dealer, :currentMonster
  
  def initPlayers( names )
    for i in 0...names.size 
      players << Player( names[i] )
    end
  end
  private :initPlayers
  
  def nextPlayer
    # Si nunca se ha inizializado entonces empieza cualquier jugador 
    # aleatoriamente.
    if @currentPlayer == nil then
      @currentPlayer == players[ rand( 0...(players.size - 1) ) ]
    # De lo contrario hay dos opciones
    else
      # Que sea el ultimo jugador de la lista, por lo que empieza por el primero
      # de nuevo.
      if ( @currentPlayer == players.size )
        @currentPlayer = players[0]
      # Que no sea el ultimo por lo que salta al siguiente.
      else
        @currentPlayer = players[ @currentPlayer + 1 ]
      end
    end
    @currentPlayer
  end
  private :nextPlayer
  
  def nextTurnAllowed
    if @current_player == nil then
        permitido = true
    else
        permitido = @current_player.validState
    end
    permitido
  end
  private :nextTurnAllowed
  
  def setEnemies
    for i in 0...players.size
      enemy << rand( 0...(players.size-1) )
      # Hasta que no genere un numero aleatorio que no coincida con su indice
      # no sigue adelante.
      while i == enemy do
        enemy << rand( 0...(players.size-1) )
      end
      players[i].enemy << players[i]
    end
  end
  private :setEnemies
  
  def developCombat
    # ISSUE::Implementar.
  end
  
  def discardVisibleTreasures( treasures )
    for i in 0..treasures.size
      currentPlayer.discartVisibleTreasure( treasure[i] )
      dealer.giveThreasureBack( treasure[i] )
    end
  end
  
  def discardHiddenTreasures( treasures )
    for i in 0..treasures.size
      currentPlayer.discartHiddenTreasure( treasure[i] )
      dealer.giveThreasureBack( treasure[i] )
    end
  end
  
  def makeTreasuresVisible( treasures )
    # ISSUE::Implementar.
  end
  
  def initGame( players )
    initPlayers( players )
    setEnemies
    nextTurn
    dealer.initCards
  end
  
  def nextTurn
    stateOK = nextTurnAllowed
    
    if stateOK then
      currentMonster = dealer.nextMonster
      currentPlayer = nextPlayer
      dead = currentPlayer.dead
   
      if dead then
        currentPlayer.initTreasures
      end
    end
    stateOK
  end
  
  def endOfGame( result )
    result == WINGAME
  end
end
