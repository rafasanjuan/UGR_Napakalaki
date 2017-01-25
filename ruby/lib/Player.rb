#encoding: UTF-8

require_relative "BadConsequence"
require_relative "CardDealer"
require_relative "CombatResult"
require_relative "Dice"
require_relative "Monster"
require_relative "Prize"
require_relative "Treasure"
require_relative "TreasureKind"
require_relative "Cultist"
require_relative "CultistPlayer"

module NapakalakiGame
  class Player

    @@MAXLEVEL = 10
    attr_reader :name, :level, :dead, :canISteal, :hiddenTreasures, :visibleTreasures 
    attr_accessor :enemy , :pendingBadConsequence
		
		
    def initialize( name )
      @name = name
      @level = 0
      @dead = true
      @canISteal = true
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      @pendingBadConsequence = nil
    end
    
    def copyConstructor(player)
      @name = player.name
      @level = player.level
      @dead = player.dead
      @canISteal = player.canISteal
      @visibleTreasures = player.visibleTreasures
      @hiddenTreasures = player.hiddenTreasures
      @pendingBadConsequence = player.pendingBadConsequence
      @enemy = player.enemy
    end
    

    def getHiddenTreasures
      @hiddenTreasures
    end

    def getVisibleTreasures
      @visibleTreasures
    end

    def bringToLife
      @dead = false
    end
    private :bringToLife

    def incrementLevels( l )
      @level = @level + l
    end
    private :incrementLevels

    def decrementLevels( l )
      @level = @level - l
        
      if @level < 1
        @level = 1
      end
    end
    private :decrementLevels

    def applyPrize( m )
      nLevels = m.getLevelsGained
      incrementLevels( nLevels )
      nTreasures = m.getTreasuresGained
      if nTreasures > 0 then
        for i in 0..( nTreasures - 1 )
          @hiddenTreasures<<CardDealer.instance.nextTreasure 
        end
      end
    end
    private :applyPrize

    def applyBadConsequence( m )
      badConsequence = m.badConsequence
      nLevels = m.getLevelsGained
      decrementLevels( nLevels )

      @pendingBadConsequence = badConsequence.adjustToFitTreasureLists( @visibleTreasures, @hiddenTreasures )
    end
    private :applyBadConsequence

    def canMakeTreasureVisible( t )
      resultado = true
      cuantos_del_mismo_tipo = howManyVisibleTreasures( t.type )
=begin
      # Los tesoros de una mano y dos manos son especiales.
      if t.type != TreasureKind::ONEHAND then
        if cuantos_del_mismo_tipo > 2
          resultado = false
        elsif t.type == TreasureKind::BOTHHANDS then
          tesoro = Treasure.new( "aux", 0, TreasureKind::ONEHAND )
          cuantos_de_una_mano = howManyVisibleTreasures( tesoro )
            if cuantos_de_una_mano > 0 then
              resultado = false
            end
        end
      # El resto no puede aparecer mas de una vez.
      else
        if cuantos_del_mismo_tipo > 1 then
          resultado = false
        end
      end
=end
      puts "jiji"
      resultado
    end
    private :canMakeTreasureVisible

    def howManyVisibleTreasures( tKind )
      numero_de_tesoros = 0

      for i in 0..( @visibleTreasures.size - 1 )
        if @visibleTreasures[i].type == tKind
          numero_de_tesoros = numero_de_tesoros + 1
        end
      end

      numero_de_tesoros
    end
    :howManyVisibleTreasures

    def dieIfNoTreasures
      if @visibleTreasures.empty? && @hiddenTreasures.empty?
        @dead = true
      end
    end
    private :dieIfNoTreasures

    def combat( m )
      # ISSUE::No es seguro que funcione, todavia es un esquema.
      
      myLevel = getCombatLevel
      monsterLevel = m.combatLevel

      if !@canISteal then
        number = @dice.nextNumber
        if number < 3 then
          enemyLevel = @enemy.getCombatLevel
          monsterLevel = monsterLevel + enemyLevel
        end
      end

      if myLevel > monsterLevel then
        applyPrize( m )
        if @level >= @@MAXLEVEL
          combatResult = CombatResult::WINGAME
        else
          combatResult = CombatResult::WIN
        end
      else
        applyBadConsequence( m )
        if(shouldConvert)
          puts 'Te has convertido en sectario'
          combatResult = CombatResult::LOSEANDCONVERT
        else
          combatResult = CombatResult::LOSE
        end
      end

      combatResult
    end

    def makeTreasureVisible( t )
      canI = canMakeTreasureVisible( t )
      if canI then
        @visibleTreasures << t
        @hiddenTreasures.delete( t )
      end
    end

    def discardVisibleTreasure( t )
      @visibleTreasures.delete( t )
      if !@pendingBadConsequence.nil? 
				if(!@pendingBadConsequence.isEmpty())
					@pendingBadConsequence.substractVisibleTreasure( t )
				end
      end
			CardDealer.instance.giveTreasureBack(t)
      dieIfNoTreasures
    end

    def discardHiddenTreasure( t )
      @hiddenTreasures.delete( t )
      if !@pendingBadConsequence.nil?
				if (!@pendingBadConsequence.isEmpty())
				 @pendingBadConsequence.substractHiddenTreasure( t )
				end
      end
      CardDealer.instance.giveTreasureBack(t)
      dieIfNoTreasures
    end

    def validState
      # ISSUE::Comprobar que los tesoros que lleva el jugador al equiparselos
      # estan en un estado valido.
      estado_valido = false
			if(!@pendingBadConsequence.nil?)
				estado_valido = ( @pendingBadConsequence.isEmpty() && @hiddenTreasures.length <= 4)
			end
			return estado_valido
    end

    def initTreasures
      bringToLife

      dealer = CardDealer.instance
      dice = Dice.instance

      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure

      number = dice.nextNumber

      if number > 1 then
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end

      if number == 6 then
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end

    def stealTreasure
      canI = @canISteal
      if canI then
        canYou = @enemy.canYouGiveMeATreasure
        if canYou then
          treasure = @enemy.giveMeATreasure
          @hiddenTreasures << treasure
          @canISteal = false
        end
      end
    end

    # Devuelve un tesoro oculto al azar.
    def giveMeATreasure
      #Comprobar que se puede
      @hiddenTreasures[ random( @hiddenTreasures.size ) ]
      #Eliminarlo del array
      #return
    end
    private :giveMeATreasure

    def canYouGiveMeATreasure
      puede = true
      if @visibleTreasures.empty?
        puede = false
      end
      puede
    end
    #private :canYouGiveMeATreasure

    def discardAllTreasures
			copy_visible_treasures = Array.new(@visibleTreasures)
			copy_hidden_treasures = Array.new(@hiddenTreasures)
      copy_visible_treasures.each do |x|
        discardVisibleTreasure( x )
      end
      copy_hidden_treasures.each do |y|
        discardHiddenTreasure( y )
      end
    end

    def to_s
      @name
    end
    
    def getCombatLevel
      nivel = @level
      
      @visibleTreasures.each do |x|
        nivel = nivel + x.bonus
      end
      
      nivel
    end
    
    def getOponentLevel(monster)
      monster.combatLevel
    end
    
    def shouldConvert
			@dice = Dice.instance
      number = @dice.nextNumber
      return number == 6
    end
    
  end
end