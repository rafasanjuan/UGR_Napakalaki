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
    # ISSUE::Implementar
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
    # ISSUE::Implementar
  end
  
  def makeTreasureVisible( t )
    # ISSUE::Implementar
  end
  
  def discardVisibleTreasure( t )
    visibleTreasures.remove( t )
    if pendingBadConsequence == null and !pendingBadConsequence.isEmpty()
      pendingBadConsequence.substractVisibleTreasure( t )
    end
    currentPlayer.dieIfNoTreasures
  end
  
  def discardHiddenTreasure( t )
    # ISSUE::Implementar
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
