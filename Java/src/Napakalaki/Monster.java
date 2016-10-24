/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author juanjomartin97
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bad_consequence;
    
    Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.bad_consequence = bc;
        this.prize = prize;
    }
    
    String GetName(){
        return name;
    }
    
    int GetCombatLevel(){
        return combatLevel;
    }
    BadConsequence Getbc(){
        return bad_consequence;
    }
    Prize GetPrize(){
        return prize;
    }
    
    public String toString(){
        return "El nombre del monsturo = " + name + "Puntos de nivel = " + Integer.toString(combatLevel) + prize.toString() + bad_consequence.toString();
    }
    
}
