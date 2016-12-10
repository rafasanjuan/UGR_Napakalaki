#encoding: UTF-8

module NapakalakiGame
class Prize
  
  attr_reader :treasures, :levels
  
  def initialize( treasures, levels )
    @treasures = treasures
    @levels = levels
  end
  
  #def to_s
  #  "Tesoros ganados: #{@treasures} \n Niveles ganados: #{@level}"
  #end
  
end
end