#encoding: UTF-8

require "singleton"
require_relative "BadConsequence"
require_relative "CardDealer"
require_relative "CombatResult"
require_relative "Dice"
require_relative "Monster"
require_relative "Player"
require_relative "Prize"
require_relative "Treasure"
require_relative "TreasureKind"

module NapakalakiGame
class Napakalaki
  
  include Singleton
  attr_accessor :currentPlayer, :players, :dealer, :currentMonster
    
  def initialize
    @currentPlayer = 0
    @currentMonster = Monster.new
  end
  
  def initPlayers( names )
    @dealer = CardDealer.instance
    @players = Array.new
    names.each do |name|
      players << Player.new( name )
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
  
=begin
  def setEnemies
    id_enemigo = -1
    for i in 0..@players.size
      id_enemigo << rand( 0..(@players.size-1) )
      # Hasta que no genere un numero aleatorio que no coincida con su indice
      # no sigue adelante.
      while i == id_enemigo do
        id_enemigo << rand( 0...(@players.size-1) )
      end
      @players[i].enemy = @players[id_enemigo]
    end
  end
  private :setEnemies
=end
  def setEnemies
    no_asignado = true
    
    for i in 0..@players.length-1
      while no_asignado
        aleatorio = rand(@players.length)
        if(aleatorio != i)
          @players[i].enemy = @players[aleatorio]
          no_asignado = false
        end
      end
      no_asignado = true
    end
  end
  
  def developCombat
    currentPlayer.combat( currentMonster )
  end
  
  def discardVisibleTreasures( treasures )
    for i in 0..treasures.size
      currentPlayer.discartVisibleTreasure( treasures[i] )
      dealer.giveThreasureBack( treasures[i] )
    end
  end
  
  def discardHiddenTreasures( treasures )
    for i in 0..treasures.size
      currentPlayer.discartHiddenTreasure( treasures[i] )
      dealer.giveThreasureBack( treasures[i] )
    end
  end
  
  def makeTreasuresVisible( treasures )
    for i in 0..treasures.size
      currentPlayer.makeTreasureVisible( treasures[i] )
    end
  end
  
  def initGame( players )
    initPlayers( players )
    setEnemies
    nextTurn
    @dealer.initCards
  end
  
  def nextTurn
    stateOK = nextTurnAllowed
    
    if stateOK then
      @currentMonster = @dealer.nextMonster
      @currentPlayer = nextPlayer
      dead = @currentPlayer.dead
   
      if dead then
        @currentPlayer.initTreasures
      end
    end
    stateOK
  end
  
  def endOfGame( result )
    result == WINGAME
  end
end

end