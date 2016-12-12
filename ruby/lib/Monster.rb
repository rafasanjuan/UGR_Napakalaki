#encoding: UTF-8

module NapakalakiGame
  class Monster
    attr_reader :name, :combatLevel, :prize, :badConsequence

    def initialize( aName,combatLvl, aPrize, bc )
       @name            = aName
       @combatLevel     = combatLvl
       @prize           = aPrize
       @badConsequence = bc
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