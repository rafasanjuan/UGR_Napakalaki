# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Monster
  attr_reader :name,:combatLevel,:prize,:bad_consequence
  
  def initialize(name,combatLvl,prize,bc)
     @name = name
     @combatLevel = combatLvl
     @prize = prize
     @bad_consequence = bc
  end
  
end
