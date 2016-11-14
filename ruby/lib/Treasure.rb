#encoding: UTF-8

class Treasure
  
  attr_reader :name, :bonus, :type
  
  def initialize( aName, aBonus, t )
    @name = aName
    @bonus = aBonus
    @type = t
  end
end
