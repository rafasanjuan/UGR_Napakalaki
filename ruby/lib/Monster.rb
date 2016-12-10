#encoding: UTF-8

module NapakalakiGame
class Monster
  attr_reader :name, :combatLevel, :prize, :bad_consequence
  
  def initialize( aName = 0,combatLvl = 0, aPrize = 0, bc = 0 )
     @name = aName
     @combatLevel = combatLvl
     @prize = aPrize
     @bad_consequence = bc
  end
  
  def getLevelsGained
    @prize.levels
  end
  
  def getTreasuresGained
    @prize.treasures
  end
  #def to_s
  #  "El nombre del monstruo = #{@name} Puntos de nivel = #{@combatLevel}"
  #end
end
end