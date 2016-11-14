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
    unusedTreasures.shuffle!
  end
  
  def shuffleMonsters
    unusedMonsters.shuffle!
  end

  def nextTreasure
    # ISSUE::Implementar
  end
  
  def nextMonster
    # ISSUE::Implementar
  end
  
  def giveTreasureBack( t )
    usedTreasures << t
  end

  def giveMonsterBack( m )
    usedTreasures << m
  end
  
  def initCards
    # ISSUE::Implementar
  end

end