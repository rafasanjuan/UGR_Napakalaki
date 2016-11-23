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
    # Si no quedan cartas:
    if @unusedTreasures.empty? then
      # Devolvemos las cartas que se han usado al mazo
      @unusedTreasures = @usedTreasures
      # Las borramos del mazo de usadas
      @usedTreasures.clear
      # Y barajamos el mazo
      shuffleTreasures
    # Si quedan cartas
    else
      # ISSUE::El guion no clarifica si hay que meter aqui la carta en el
      # mazo de cartas usadas.
      siguiente_tesoro << @unusedTreasures[ @unusedTreasures.size-1 ]
      @unusedTreasures.delete( @unusedTreasures.size-1 )
    end
    siguiente_tesoro
  end
  
  def nextMonster
    # Si no quedan cartas:
    if @unusedMonsters.empty? then
      # Devolvemos las cartas que se han usado al mazo
      @unusedMonsters = @usedMonsters
      # Las borramos del mazo de usadas
      @unusedMonsters.clear
      # Y barajamos el mazo
      shuffleTreasures
    # Si quedan cartas
    else
      # ISSUE::El guion no clarifica si hay que meter aqui la carta en el
      # mazo de cartas de monstruos usadas.
      siguiente_tesoro << @unusedMonsters[ @unusedMonsters.size-1 ]
      @unusedMonsters.delete( @unusedMonsters.size-1 )
    end
    siguiente_tesoro
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