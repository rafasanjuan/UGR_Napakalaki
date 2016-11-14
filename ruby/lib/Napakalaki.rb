#encoding: UTF-8

class Napakalaki
  
  require "singleton"
  
  attr_accesor :currentPlayer, :players, :dealer, :currentMonster
  
  def initPlayers( names )
    # ISSUE::Implementar.
  end
  private :initPlayers
  
  def nextPlayer
    # ISSUE::Implementar.
  end
  private :nextPlayer
  
  def nextTurnAllowed
    # ISSUE::Implementar.
  end
  private :nextTurnAllowed
  
  def setEnemies
    # ISSUE::Implementar.
  end
  private :setEnemies
  
  def developCombat
    # ISSUE::Implementar.
  end
  
  def discardVisibleTreasures( treasures )
    # ISSUE::Implementar.
  end
  
  def discardHiddenTreasures( treasures )
    # ISSUE::Implementar.
  end
  
  def makeTreasuresVisible( treasures )
    # ISSUE::Implementar.
  end
  
  def initGame( players )
    # ISSUE::Implementar.
  end
  
  def getCurrentPlayer
    # ISSUE::Implementar.
  end
  def getCurrentMonster
    # ISSUE::Implementar.
  end
  def nextTurn
    # ISSUE::Implementar.
  end
  def endOfGame( result )
    # ISSUE::Implementar.
  end
end
