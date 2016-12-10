#encoding: UTF-8

module NapakalakiGame
  
  require "singleton"
  
  class Dice
    include Singleton

    def nextNumber
      rand( 1...7 )
    end
  end
  
end