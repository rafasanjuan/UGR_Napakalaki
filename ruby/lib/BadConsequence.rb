#encoding: utf-8

class BadConsequence
  
  attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures, :death
  private_class_method :new
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, isDeath) 
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @death = isDeath
  end
  
  def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
  end
    
  def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText,someLevels,0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
  end
    
  def self.newDeath (aText)
      new( aText, 0, 0, 0, Array.new, Array.new, true )
  end
  
  def to_s
    "#{@text} Niveles perdidos = #{@levels} Tesoros perdidos #{@nVisibleTreasures} "
  end
end
