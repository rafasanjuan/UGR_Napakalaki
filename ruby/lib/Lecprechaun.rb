# Examen practica 1.
#encoding: UTF-8

module NapakalakiGame
class Leprechaun

  attr_reader :name
  private_class_method :new
  
  def initialize( aName, aGoldpot )
    @name = aName
    @goldpot = aGoldpot
  end
  
  def self.newName ( aName )
      new( aName, [] )
  end
    
  def self.newNameAndGoldpot ( aName, aGoldpot )
      new( aName, aGoldpot )
  end
  
  def addTreasureKind( treasure_kind )
    @goldpot.push( treasure_kind )
  end
  
  def to_s
    tiene_zapatos = false
    for i in 0...@goldpot.size 
      if @goldpot[i] == TreasureKind::SHOE and tiene_zapatos == false then
        "Oh yes!"
        tiene_zapatos = true
      end
      if tiene_zapatos == false then
        "Oh no!"
      end
    end
  end
  
end
end