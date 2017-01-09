#encoding: UTF-8

module NapakalakiGame
  class Monster
    attr_reader :name, :combatLevel, :prize, :badConsequence, :levelChangeAgainstCultistPlayer

    def initialize( aName,combatLvl, aPrize, bc, lvlChangeAgainstCultistPlayer = 0 )
       @name            = aName
       @combatLevel     = combatLvl
       @prize           = aPrize
       @badConsequence = bc
       @levelChangeAgainstCultistPlayer = lvlChangeAgainstCultistPlayer
    end

    def getCombatLevelAgainstCultistPlayer
      return getLevelsGained + @levelChangeAgainstCultistPlayer
    end
    
    def getLevelsGained
      @prize.levels
    end

    def getTreasuresGained
      @prize.treasures
    end
    
    def to_s
      "#{@name}. Nivel = #{@combatLevel}"
    end
  end
end