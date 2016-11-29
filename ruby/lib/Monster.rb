class Monster
  attr_reader :name, :combatLevel, :prize, :bad_consequence
  
  def initialize( aName,combatLvl, aPrize,bc )
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
