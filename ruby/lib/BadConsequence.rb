#encoding: utf-8

class BadConsequence
  
  attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures, :death
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death) 
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
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
  
  
  def to_s
    "#{@text} Niveles perdidos = #{@levels} Tesoros perdidos #{@nVisibleTreasures} "
  end
end
