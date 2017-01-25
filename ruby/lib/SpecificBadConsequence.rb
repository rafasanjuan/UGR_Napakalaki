require_relative "TreasureKind"
require_relative "BadConsequence"

module NapakalakiGame


class SpecificBadConsequence < BadConsequence
  
  attr_reader :specificVisibleTreasures, :specificHiddenTreasures
  
  def initialize(aText, someLevels, someSpecificTreasures, someHiddenTreasures)
    super(aText, someLevels, false)
    @specificVisibleTreasures = someSpecificTreasures
    @specificHiddenTreasures = someHiddenTreasures
  end
public_class_method :new

  def isEmpty
    return (@specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?)
  end
  
  def substractVisibleTreasure(t)
    if(!@specificVisibleTreasures.empty?)then
      @specificVisibleTreasures.delete_at(@specificVisibleTreasures.index(t) ||@specificVisibleTreasures.length)
    end
  end
  
  def substractHiddenTreasure(t)
    if(!@specificHiddenTreasures.empty?) then
      @specificHiddenTreasures.delete_at(@specificHiddenTreasures.index(t) ||@specificHiddenTreasures.length)
    end
  end
  
  def adjustToFitTreasureLists(visibleT, hiddenT)
      visibleCopy = Array.new(@specificVisibleTreasures)
      hiddenCopy = Array.new(@specificHiddenTreasures)
      visibles_a_dev = Array.new
			hidden_a_dev = Array.new
      if (@specificVisibleTreasures.length > 0)
        visibleT.each { |tesoro|  
          if (visibleCopy.include?(tesoro.type))
            visibles_a_dev << tesoro.type
            visibleCopy.delete_at(visibleCopy.index(tesoro.type))
          end
        }
      end
    
      if (@specificHiddenTreasures.length > 0)
        hiddenT.each { |tesoro|  
          if (hiddenCopy.include?(tesoro.type))
           hidden_a_dev << tesoro.type
            hiddenCopy.delete_at(hiddenCopy.index(tesoro.type))
          end
        }
      end
    
			a_devolver = SpecificBadConsequence.new(self.text, self.levels, visibles_a_dev, hidden_a_dev)
		
      return a_devolver
    end

#to_s

end
end