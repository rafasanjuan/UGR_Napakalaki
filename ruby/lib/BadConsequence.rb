#encoding: UTF-8

require_relative "TreasureKind"

module NapakalakiGame
  class BadConsequence

    @@MAXTREASURES = 10

    attr_reader :levels, :death, :text 

    # Constructores
    def initialize( aText, someLevels, isDeath) 
      @text = aText
      @levels = someLevels
      @death = isDeath
    end
		
		class << self
			protected :new
		end

    def isEmpty
			raise NotImplementedError.new("abstract methods can't have a body")
    end

    def substractVisibleTreasure( t )
			raise NotImplementedError.new("abstract methods can't have a body")
    end

    def substractHiddenTreasure( t )
			raise NotImplementedError.new("abstract methods can't have a body")
    end

    def adjustToFitTreasureLists( v, h )
			raise NotImplementedError.new("abstract methods can't have a body")
    end
  end
end