#encoding: UTF-8

require "singleton"
module NapakalakiGame
  class Dice
    include Singleton
    def nextNumber
      #rand = Random.new
      rand( 1...7 )
    end
  end
end
