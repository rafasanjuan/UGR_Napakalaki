# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "TreasureKind"
require_relative "BadConsequence"

module NapakalakiGame


class SpecificBadConsequence < BadConsequence
  
  attr_reader :specificVisibleTreasures, :specificHiddenTreasures
  
  def initialize(aText, someLevels, someSpecificTreasures, someHiddenTreasures)
    super(aText, someLevels)
    @specificVisibleTreasures = someSpecificTreasures
    @specificHiddenTreasures = someHiddenTreasures
  end
public_class_method :new

  def isEmpty
    empty = (@specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?)
    empty
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
  
  def adjustToFitTreasureLists(v,h)
    
  end



end
end