#encoding: UTF-8

class CardDealer
  
  require "singleton"
  
  attr_accesor :unusedTreasures, :usedTreasures, :unusedMonsters, :usedMonsters
  
  def initTreasureCardDeck
    # ISSUE::Implementar
  end
  private :initTreasureCardDeck
  
 def initMonsterCardDeck
   # ISSUE::Implementar
 end
 private :initMonsterCardDeck
 
  def shuffleTreasures
    # ISSUE::Implementar
  end
  
  def shuffleMonsters
    # ISSUE::Implementar
  end

  def nextTreasure
    # ISSUE::Implementar
  end
  
  def nextMonster
    # ISSUE::Implementar
  end
  
  def giveTreasureBack( t )
    # ISSUE::Implementar
  end

  def giveMonsterBack( m )
    # ISSUE::Implementar
  end
  
  def initCards
    # ISSUE::Implementar
  end

end