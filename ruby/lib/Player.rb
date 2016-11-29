#encoding: UTF-8

class Player
  
  attr_reader :name, :level, :dead, :canISteal, :hiddenTreasures, :visibleTreasures 
  attr_writer :pendingBadConsequence, :enemy
  #attr_accesor 
  
  private_class_method :bringToLife, :incrementLevels, :decrementLevels
  private_class_method :applyPrize, :applyBadConsquence, :canMakeTreasureVisible
  private_class_method :dieIfNoTreasures, :howManyVisibleTreasures, :giveMeATreasure
  private_class_method :canYouGiveMeATreasure, :haveStolen
  
  def initialize( name )
    @name = name
    @level = 0
    @dead = true
    @canISteal = true
    @visibleTreasures = Array.new
    @hiddenTreasures = Array.new
    @pendingBadConsequence = BadConsequence.newLevelNumberOfTreasures( "", 0, 0, 0 )
  end
  
  def bringToLife
    dead = false
  end

  def incrementLevels( l )
    if l > 0
      incrementLevels = incrementLevels + l
    end
  end
  
  def decrementLevels( l )
    if l > 0
      incrementLevels = incrementLevels - l
    end
  end
  
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
  
  def applyBadConsequence( m )
    # ISSUE::Implementar
  end
  
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
  
  def howManyVisibleTreasures( tKind )
    numero_de_tesoros = 0
    
    for i in 0...@visibleTreasures.size
      if @visibleTreasures[i].type == tKind
        numero_de_tesoros = numero_de_tesoros + 1
      end
    end
    
    numero_de_tesoros
  end
  
  def dieIfNoTreasures
    if @visibleTreasures.empty? && @hiddenTreasures.empty?
      @dead = true
    end
  end
  
  def getHiddenTreasures
    # ISSUE::Implementar
  end
  
  def getVisibleTreasures()
    # ISSUE::Implementar
  end
  
  def combat( m )
    # ISSUE::No es seguro que funcione, todavia es un esquema.
    myLevel = @level
    monsterLevel = currentMonster.level
    
    if !@canISteal then
      number = Dice.nextNumber
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
    # ISSUE::Implementar
  end
  
  def getLevels
    # ISSUE::Implementar
  end
  
  def stealTreasure
    # ISSUE::Implementar
  end
  
  def setEnemy( enemy )
    # ISSUE::Implementar
  end
  
  # Devuelve un tesoro oculto al azar.
  def giveMeATreasure
    @hiddenTreasures[ random( 0...@hiddenTreasures.size ) ]
  end
  
  def canYouGiveMeATreasure
    puede = true
    if @visibleTreasures.empty?
      puede = false
    end
    puede
  end

  def discardAllTreasures
    # ISSUE::Implementar
  end
end
