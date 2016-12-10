#encoding: UTF-8

require_relative 'BadConsequence.rb'
require_relative 'TreasureKind.rb'
require_relative 'Prize.rb'
require_relative 'Monster.rb'

module NapakalakiGame


@@monster = Array.new()
$MAX=5


# 3 Byakhees de bonanza

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes tu armadura visible y otra oculta', 0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
@@monster << Monster.new('3 Byakhees de bonanza', 8, prize, bad_consequence)

# Tenochtitlan

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Embobados con el lindo primigenio te descartas de tu casco visible', 0, [TreasureKind::HELMET], 0)
@@monster << Monster.new('Tenochtitlan', 2, prize, bad_consequence)

# El sopor de Dunwich

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('El primordial bostezo contagioso. Pierdes el calzado visible', 0, [TreasureKind::SHOE], 0)
@@monster << Monster.new('El sopor de Dunwich', 2, prize, bad_consequence)

# Demonios de Magaluf

prize = Prize.new(4,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta', 0,[TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
@@monster << Monster.new('Demonios de Magaluf', 2, prize, bad_consequence)

# El gorrón en el umbral

prize = Prize.new(3,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles', 0, $MAX ,0)
@@monster << Monster.new('El gorron en el umbral', 13, prize, bad_consequence)

# H.P. Munchcraft

prize = Prize.new(2, 1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes la armadura visible', 0, [TreasureKind::ONEHAND], 0)
@@monster << Monster.new('H.P. Munchcraft', 6, prize, bad_consequence)

# Necrófago

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Sientes bichos bajo la ropa. Descarta la armadura visible', 0, [TreasureKind::ARMOR], 0)
@@monster << Monster.new('Necrofago', 13, prize, bad_consequence)

# El rey de rosado

prize = Prize.new(4,2)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles', 5 , 3, 0)
@@monster << Monster.new('El rey de rosado', 13, prize, bad_consequence)

# Flecher

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y pierdes 2 niveles', 2 , 0, 0)
@@monster << Monster.new('Flecher', 2, prize, bad_consequence)

# Los hondos

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Estos monstruos resultanbastante superficiales y te aburren mortalmente. Estas muerto', 0, 0, 0)
@@monster << Monster.new('Los hondos', 8, prize, bad_consequence)

#Semillas Cthulu

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ocultos', 2 , 0, 2)
@@monster << Monster.new('Semillas Cthulu', 4, prize, bad_consequence)

# Dameargo cohone

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Te intentas escaquear. Pierdes una mano visible', 0 , [TreasureKind::ONEHAND], 0)
@@monster << Monster.new('Dameargo', 1, prize, bad_consequence)

# Pollipiólipo volante

prize = Prize.new(3,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito.Pierdes 3 niveles.', 3, 0, 0)
@@monster << Monster.new('Pollipiolipo volante', 3, prize, bad_consequence)

# Y skhtihyssg-Goth

prize = Prize.new(3,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('No lehace gracia que pronuncien mal su nombre. Estas muerto', 0, 0, 0)
@@monster << Monster.new('Y skhtihyssg-Goth', 14, prize, bad_consequence)

# Familia Feliz

prize = Prize.new(3,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('La familia te atrapa. Estas muerto.', 0, 0, 0)
@@monster << Monster.new('Familia feliz', 1, prize, bad_consequence)

# Roboggoth

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles', 2, [TreasureKind::BOTHHAND], 0)
@@monster << Monster.new('Roboggoth', 1, prize, bad_consequence)

# El espía sordo

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Te asusta en la noche. Pierdes un casco visible', 0, [TreasureKind::HELMET], 0)
@@monster << Monster.new('El espia sordo', 5, prize, bad_consequence)

# Tongue

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes 2 niveles y 2 tesoros visibles', 2, 2, 0)
@@monster << Monster.new('Tongue', 19, prize, bad_consequence)

# Bicéfalo

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Te faltan manos paratanta cabeza. Pierdes 3 niveles y tustesoros visibles de las manos.', 3, $MAX, 0)
@@monster << Monster.new('Bicefalo', 21, prize, bad_consequence)


def NivelMAyorA(lista_monstruos , lvl)
	devolver = Array.new
  
	for i in 0...lista_monstruos.size 
    elemento = lista_monstruos[i]
		if elemento.combatLevel > lvl then
			devolver.push(elemento)
      puts elemento.name
		end
	end
  
	devolver   #return
end

def PerdidaDeNivel(lista_monstruos)
	devolver = Array.new
	
	for i in 0...lista_monstruos.size
    perdida_nivel = lista_monstruos[i].bad_consequence.levels > 0 &&  lista_monstruos[i].bad_consequence.nVisibleTreasures == 0 &&  lista_monstruos[i].bad_consequence.nHiddenTreasures == 0
		if perdida_nivel then
			devolver.push(lista_monstruos[i])
      puts lista_monstruos[i].name
		end
	end
	
	devolver #return
end

def GanaNivelSuperiorA (lista_monstruos, level)
	devolver = Array.new
	
	for i in 0...lista_monstruos.size 
		if lista_monstruos[i].prize.levels > level then
			devolver.push(lista_monstruos[i])
      puts lista_monstruos[i].name
		end
	end
	
	devolver #return
end

def MalRolloPerder (lista_monstruos, treasure_kind)
	devolver = Array.new
	
	for i in 0...lista_monstruos.size 
		if (lista_monstruos[i].bad_consequence.nVisibleTreasures) > 0  then
      for j in 0...lista_monstruos.bad_consequence.specificVisibleTreasures.size
        if lista_monstruos.bad_consequence.specificVisibleTreasures[j] == treasure_kind then
          devolver.push(lista_monstruos[i])
          puts lista_monstruos[i].name
        end
      end
		end
    if (lista_monstruos[i].bad_consequence.HiddenTreasures) > 0 then
        if lista_monstruos.bad_consequence.specificHiddenTreasures[j] == treasure_kind then
          devolver.push(lista_monstruos[i])
          puts lista_monstruos[i].name
        end
    end
	end
	
	devolver #return
end



puts "Lista de monstruos con nivel superior a 10\n"
NivelMAyorA(@@monster, 10)

puts "\nLista monstruos que tengan un mal rollo en el que solo se pierdan niveles\n"
PerdidaDeNivel(@@monster)

puts "\nLista de monstruos que implican ganar mas de 1 nivel\n"
GanaNivelSuperiorA(@@monster, 1)

puts "\nLista de monstruos que tengan un mal rollo que implique perder la armadura\n"
MalRolloPerder(@@monster, [TreasureKind::ARMOR])

end