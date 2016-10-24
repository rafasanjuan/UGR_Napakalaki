class BadConsequence
  
  attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures, :death
  
  def initialize( text, levels, nVisibleTreasures, nHiddenTreasures, specificVisibleTreasures= Array.new, specificHiddenTreasures= Array.new, death )
    @text = text
    @levels = levels
    @nVisibleTreasures = nVisibleTreasures
    @nHiddenTreasures = nHiddenTreasures
    @specificVisibleTreasures = specificVisibleTreasures
    @specificHiddenTreasures = specificHiddenTreasures
    @death = death
  end
  
  def self.new_level_number_of_treasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
  end
    
  def self.new_level_specific_treasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText,someLevels,0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
  end
    
  def self.new_death (aText)
      new( aText, 0, 0, 0, Array.new, Array.new, true )
  end  
end
