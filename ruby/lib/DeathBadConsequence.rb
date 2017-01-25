# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative	"NumericBadConsequence"
require_relative	"Player"

module NapakalakiGame
	
	

class DeathBadConsequence < NumericBadConsequence
  attr_reader :death
  def initialize(aText)
    super(aText,0,0,0)
    @death = true
  end
  public_class_method :new
  
  def to_s
      resp = @text

      if (@death == true)
        resp += "\nEstas muerto"
      end
      
      resp
  end
  
  
end
end