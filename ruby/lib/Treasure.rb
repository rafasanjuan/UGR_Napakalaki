#encoding: UTF-8

module NapakalakiGame
  class Treasure

    attr_reader :name, :bonus, :type

    def initialize( aName, aBonus, t )
      @name = aName
      @bonus = aBonus
      @type = t
    end
  end
end