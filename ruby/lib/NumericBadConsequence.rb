# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "TreasureKind"
require_relative "BadConsequence"
module NapakalakiGame


class NumericBadConsequence < BadConsequence
  attr_reader :nVisibleTreasures, :nHiddenTreasures
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    super(aText, someLevels)
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
  end
public_class_method :new

def isEmpty
  vacio = (@nVisibleTreasures + @nHiddenTreasures == 0)
  vacio
end

def substractVisibleTreasure( t = nil )
  if(nVisibleTreasures > 0) then
    nVisibleTreasures -= 1
  end
end

def substractHiddenTreasure (t = nil)
  if(nHiddenTreasures > 0) then
    nHiddenTreasures -= 1
  end
end

def adjustToFitTreasureLists(v,h)
  if(@nVisibleTreasures > v.length)
    visiblesBc = v.length
  else
    visiblesBc = @nVisiblesTreasures
  end
  
  if(@nHiddenTreasures > h.length)
    hiddenBc = h.length
  else
    hiddenBc = @nHiddenTreasures
  end
  
  bc = NumericBadConsequence.new(@text, @levels, visibleBc, hiddenBc)
  bc
end

#to_s
end
end

