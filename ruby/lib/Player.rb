#encoding: UTF-8


require_relative "BadConsequence"
require_relative "CardDealer"
require_relative "CombatResult"
require_relative "Dice"
require_relative "Monster"
require_relative "Prize"
require_relative "Treasure"
require_relative "TreasureKind"

module NapakalakiGame
class Player
  
  attr_reader :name, :level, :dead, :canISteal, :hiddenTreasures, :visibleTreasures 
  attr_writer :pendingBadConsequence, :enemy
  #attr_accesor 
  
  def initialize( name )
    @name = name
    @level = 0
    @dead = true
    @canISteal = true
    @visibleTreasures = Array.new
    @hiddenTreasures = Array.new
    @pendingBadConsequence = BadConsequence.newLevelNumberOfTreasures( "", 0, 0, 0 )
  end
  
  def getHiddenTreasures
    @hiddenTreasures
  end
  
  def getVisibleTreasures
    @visibleTreasures
  end
  
  def bringToLife
    @dead = false
  end
  private :bringToLife

  def incrementLevels( l )
    if l > 0
      incrementLevels = incrementLevels + l
    end
  end
  private :incrementLevels
  
  def decrementLevels( l )
    if l > 0
      incrementLevels = incrementLevels - l
    end
  end
  private :decrementLevels
  
  def applyPrize( m )
    nLevels = m.getLevelsGained
    incrementLevels( nLevels )
    
    nTreasures = m.getTreasuresGained
    if nTreasures > 0 then
      for i in 0..nTreasures
        treasure = CardDealer.nextTreasure
        add( treasure )
      end
    end
  end
  private :applyPrize
  
  def applyBadConsequence( m )
    badConsequence = m.getBadConsequence
    nLevels = getLevels
    decrementLevels( nLevels )
    
    @pendingBadConsequence = badConsequence.adjustToFitTreasureLists( @visibleTreasures, @hiddenTreasures )
  end
  private :applyBadConsequence
  
  def canMakeTreasureVisible( t )
    resultado = true
    cuantos_del_mismo_tipo << howManyVisibleTreasures( t )
    
    if t.type != ONEHAND then
      if cuantos_del_mismo_tipo > 0
        resultado = false
      elsif t.type == BOTHHAND then
        tesoro = new.Treasure( aux, 0, ONEHAND )
        cuantos_de_una_mano << howManyVisibleTreasures( tesoro )
          if cuantos_de_una_mano > 0 then
            resultado = false
          end
      end
    else
      if cuantos_del_mismo_tipo > 1 then
        resultado = false
      end
    end
      
    resultado
  end
  private :canMakeTreasureVisible
  
  def howManyVisibleTreasures( tKind )
    numero_de_tesoros = 0
    
    for i in 0...@visibleTreasures.size
      if @visibleTreasures[i].type == tKind
        numero_de_tesoros = numero_de_tesoros + 1
      end
    end
    
    numero_de_tesoros
  end
  :howManyVisibleTreasures
  
  def dieIfNoTreasures
    if @visibleTreasures.empty? && @hiddenTreasures.empty?
      @dead = true
    end
  end
  private :dieIfNoTreasures
  
  def combat( m )
    # ISSUE::No es seguro que funcione, todavia es un esquema.
    myLevel = @level
    monsterLevel = currentMonster.level
    
    if !@canISteal then
      number = @dice.nextNumber
      if number < 3 then
        enemyLevel = enemy.level
        monsterLevel = monsterLevel + enemyLevel
      end
    end
    
    if myLevel > monsterLevel then
      applyPrice( m )
    else
      applyBadConsequence( m )
    end
    
    combatResult
  end
  
  def makeTreasureVisible( t )
    canI = canMakeTreasureVisible
    if canI then
      visibleTreasures.add( t )
      hiddenTreasures.remove( t )
    end
  end
  
  def discardVisibleTreasure( t )
    visibleTreasures.remove( t )
    if pendingBadConsequence == null and !pendingBadConsequence.isEmpty()
      pendingBadConsequence.substractVisibleTreasure( t )
    end
    currentPlayer.dieIfNoTreasures
  end
  
  def discardHiddenTreasure( t )
    hiddenTreasures.remove( t )
    if pendingBadConsequence == null and !pendingBadConsequence.isEmpty()
      pendingBadConsequence.substractHiddenTreasure( t )
    end
    currentPlayer.dieIfNoTreasures
  end
  
  def validState
    # ISSUE::Comprobar que los tesoros que lleva el jugador al equiparselos
    # estan en un estado valido.
    estado_valido = false
        
    if @pendingBadConsequence.isEmpty && @hiddenTreasures.size <= 4
      estado_valido = true
    end
        
    estado_valido 
  end
  
  def initTreasures
    bringToLife
    
    dealer = CardDealer.instance
    dice = Dice.instance
    
    treasure = dealer.nextTreasure
    @hiddenTreasures << treasure
    
    number = dice.nextNumber
    
    if number > 1 then
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
    end
    
    if number == 6 then
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
    end
  end
  
  def stealTreasure
    canI = canISteal
    if canI then
      enemy.canYou = canYouGiveMeATreasure
      if canYou then
        treasure = enemy.giveMeATreasure
        hiddenTreasures.add( treasure )
        canISteal = false
      end
    end
  end
  
  # Devuelve un tesoro oculto al azar.
  def giveMeATreasure
    @hiddenTreasures[ random( 0...@hiddenTreasures.size ) ]
  end
  private :giveMeATreasure
  
  def canYouGiveMeATreasure
    puede = true
    if @visibleTreasures.empty?
      puede = false
    end
    puede
  end
  private :canYouGiveMeATreasure

  def discardAllTreasures
    for i in 0..@visibleTreasures.size
      discardVisibleTreasure( @visibleTreasures[i] )
    end
    for i in 0..@hiddenTreasures.size
      discardVisibleTreasure( @hiddenTreasures[i] )
    end
  end
end
end