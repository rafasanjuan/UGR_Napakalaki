#encoding: UTF-8

require_relative "TreasureKind"

module NapakalakiGame
  class BadConsequence

    @@MAXTREASURES = 10

    private_class_method :new
    attr_reader :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures

    # Constructores
    def initialize( aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, isDeath ) 
      @text = aText
      @levels = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @specificHiddenTreasures = someSpecificHiddenTreasures
      @death = isDeath
    end

    def self.newLevelNumberOfTreasures( aText, someLevels, someVisibleTreasures, someHiddenTreasures )
        new( aText,someLevels,someVisibleTreasures,someHiddenTreasures,false,[],[] )
    end

    def self.newLevelSpecificTreasures( aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures )
        new( aText,someLevels,0,0,false,someSpecificHiddenTreasures,someSpecificVisibleTreasures )
    end

    # Metodos
    def self.newDeath( aText )
        new( aText,0,0,0,true,[],[] )
    end

    #def to_s
    #  "#{@text} Niveles perdidos = #{@levels} Tesoros perdidos #{@nVisibleTreasures} "
    #end

    def isEmpty
      vacio = false
      if @nVisibleTreasures == 0 && @nHiddenTreasures == 0 && @levels == 0 && @dead == false && @specificHiddenTreasures.empty? && @specificVisibleTreasures.empty? then
        vacio = true
      end
      vacio
    end

    def substractVisibleTreasure( t )
      borrado = false
      for i in 0...( @specificVisibleTreasures.size - 1 )
        if @specificVisibleTreasure[i] == t && borrado == false then
          @specificVisibleTreasure.delete( i )
          borrado = true
        end
      end
    end

    def substractHiddenTreasure( t )
      borrado = false
      for i in 0...( @specificVisibleTreasures.size - 1 )
        if @specificHiddenTreasures[i] == t && borrado == false then
          @specificHiddenTreasures.delete( i )
          borrado = true
        end
      end
    end

    def adjustToFitTreasureLists( v, h )
      t_visible = Array.new
      t_hidden  = Array.new

      for i in 0..( v.size - 1)
        if t_visible.index( v[i].type ) == nil then
          t_visible << v[i].type
        end
      end
      for j in 0..( h.size - 1 )
          if t_hidden.index( h[j].type ) == nil then
            t_hidden << h[j].type
          end
      end
      bs = BadConsequence.newLevelSpecificTreasures( @text, 0, t_visible, t_hidden )
      bs
    end
  end
end