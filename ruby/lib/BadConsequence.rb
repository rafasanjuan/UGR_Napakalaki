#encoding: UTF-8

class BadConsequence
  
  MAXTREASURES = 10
  
  #attr_accesor
  attr_reader :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures
  #attr_writer 
  private :new
  
  # Constructores
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
      new(aText,someLevels,someVisibleTreasures,someHiddenTreasures,false,[],[])
  end
    
  def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText,someLevels,0,0,false,someSpecificHiddenTreasures,someSpecificVisibleTreasures)
  end
    
  # Metodos
  def self.newDeath (aText)
      new(aText,0,0,0,true,[],[])
  end
  
  #def to_s
  #  "#{@text} Niveles perdidos = #{@levels} Tesoros perdidos #{@nVisibleTreasures} "
  #end
  
  def isEmpty
    # ISSUE::Implementar
  end
  
  def substractVisibleTreasure( t )
    # ISSUE::Implementar
  end
  
  def substractHiddenTreasure( t )
    # ISSUE::Implementar
  end
  
  def adjustToFitTreasureLists( v, h )
    # ISSUE::Implementar
  end
end
