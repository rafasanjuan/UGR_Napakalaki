#encoding: UTF-8

class Player
  
  # name: get
  # level: get
  
  attr_accesor :name, :level, :dead, :canISteal, :enemy, :hiddenTreasures, :visibleTreasures
  
  def initialize( name )
    # ISSUE:Implementar
  end
  
  def bringToLife
    dead = false
  end
  private :bringToLife

  def incrementLevels( l )
    # ISSUE::Implementar
  end
  private :incrementLevels
  
  def decrementLevels( l )
    # ISSUE::Implementar
  end
  private :decrementLevels
  
  def setPendingBadConsequence( b )
    # ISSUE::Implementar
  end
  private :setPendingBadConsequence
  
  def applyPrize( m )
    # ISSUE::Implementar
  end
  private :applyPrize
  
  def applyBadConsequence( m )
    # ISSUE::Implementar
  end
  private :applyBadConsquence
  
  def canMakeTreasureVisible( t )
    # ISSUE::Implementar
  end
  private :canMakeTreasureVisible
  
  def howManyVisibleTreasures( tKind )
    # ISSUE::Implementar
  end
  private :howManyVisibleTreasures
  
  def dieIfNoTreasures
    # ISSUE::Implementar
  end
  private :dieIfNoTreasures
  
  def isDead
    # ISSUE::Implementar
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
    # ISSUE::Implementar
  end
  
  def discardHiddenTreasure( t )
    # ISSUE::Implementar
  end
  
  def validState
    # ISSUE::Implementar
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
  
  def giveMeATreasure
    # ISSUE::Implementar
  end
  private :giveMeATreasure
  
  def canISteal
    # ISSUE::Implementar
  end
  
  def canYouGiveMeATreasure
    # ISSUE::Implementar
  end
  private :canYouGiveMeATreasure
  
  def haveStolen
    # ISSUE::Implementar
  end
  private :haveStolen
  
  def discardAllTreasures
    # ISSUE::Implementar
  end

end
