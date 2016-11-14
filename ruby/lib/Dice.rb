#encoding: UTF-8

class Dice
  require "singleton"
  
  def nextNumber
    rand( 1...7 )
  end
end
