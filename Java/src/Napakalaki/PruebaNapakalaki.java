/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author juanjomartin97
 */
public class PruebaNapakalaki {

    static ArrayList<Monster> monstruos = new ArrayList();
    static ArrayList<Monster> monstruos_validos = new ArrayList();
    static ArrayList<Monster> monstruos_a_imprimir = new ArrayList();
    
    public static void CreaMonstruos() {
    //Semillas Cthulhu
    
    BadConsequence badConsequence = new BadConsequence("Pierdes 2 niveles y 2"+
        "tesoros ocultos.",2,0,2);
    Prize prize = new Prize(2,1);
    monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
   
    //Dameargo
    
    badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
    prize = new Prize(2,1);
    monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
    
    //Pollipólipo volante
    
    badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
    prize = new Prize(2,1);
    monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
    
    //Yskhtihyssg-Goth
    
    badConsequence = new BadConsequence("No le hace gracia que\n" +
    "pronuncien mal su nombre. Estas\n" +
    "muerto",true);
    prize = new Prize(3,1);
    monstruos.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence, prize));
    
    //Bicefalo

    badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, Integer.MAX_VALUE, 0);
    prize = new Prize(2,1);
    monstruos.add(new Monster("Bicefalo", 21, badConsequence, prize));

    // Tongue
    
    badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
    prize = new Prize(2,1);
    monstruos.add(new Monster("Tongue", 19, badConsequence, prize));

    // El espia sordo
    
    badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
    prize = new Prize(1,1);
    monstruos.add(new Monster("El espia sordo", 5, badConsequence, prize));

    //Roboggoth

    badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
    prize = new Prize(2,1);
    monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));

    //Familia feliz

    badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.", true);
    prize = new Prize(2,1);
    monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));

    //Angeles de la noche ibicenca

    badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,
    new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
    new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
    prize = new Prize(4,1);
    monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence,
    prize));
    
    //  h.p. Munchcraft
    
    badConsequence = new BadConsequence("Pierdes la armadura visisble", 0,
    new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList() );
    prize = new Prize (2,1);
    Monster hpm = new Monster ("H.P. Munchcraft",6, badConsequence, prize);
    monstruos.add(hpm);
 
    //Necrógrafo
    
    badConsequence= new BadConsequence ("Sientes bichos bajo la ropa."
    + "Descártate la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
    new ArrayList() );
    prize = new Prize (1,1);
    monstruos.add(new Monster("Necrógrafo",13,badConsequence,prize));
 
    //Rey Rosado
    
    badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
    prize = new Prize(4,2);
    monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
 
    //Felcher
 
    badConsequence = new BadConsequence ("Toses los pulmones y pierdes dos niveles",
    2,0,0);
    prize= new Prize(1,1);
    monstruos.add(new Monster("Felcher", 2, badConsequence, prize));
 
    //los Hondos
 
    badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales"
    + " y te aburren mortalmente.Estas muerto.",true);
    prize = new Prize(2,1);
    monstruos.add(new Monster(" Los Hondos", 8, badConsequence, prize));
   
    // 3 Byakhees de bonanza
    
    badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)) , new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
    prize = new Prize(2,1);
    monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));

    // Tenochtitlan
    
    badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList()  );
    prize = new Prize(1,1);
   monstruos.add(new Monster("Tenochtitlan", 2, badConsequence, prize));


    // El sopor de Dunwich
    
    badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList() );
    prize = new Prize(1,1);
    monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));


    // Demonios de Magaluf
    
    badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)) );
    prize = new Prize(4,1);
    monstruos.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));


    // El gorrón en el umbral
    
    badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",0, Integer.MAX_VALUE, 0);
    prize = new Prize(3,1);
    monstruos.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
           
    
}
    public static ArrayList NivelMayorA(int nivel_menor){
        monstruos_validos.clear();
        int tama = monstruos.size();
        Monster monstruo_local;

        for(int i= 0; tama > i; i++){
            monstruo_local= monstruos.get(i);
            if(monstruo_local.GetCombatLevel() > nivel_menor)
                monstruos_validos.add( monstruos.get(i) );

        }
        return monstruos_validos;
    }
    public static ArrayList PerdidaNivelBc (){
        monstruos_validos.clear();
        int tama = monstruos.size();
        Monster monstruo_local;
        
        for(int i= 0; tama > i; i++){ //Recorremos el vector
            monstruo_local= monstruos.get(i);
            if(monstruo_local.Getbc().getLevels() > 0) //Los monstruos que tengan perdida de nivel
                monstruos_validos.add( monstruos.get(i) );

        }
        return monstruos_validos;
    }
    public static ArrayList GananciaLvLMas1 (){ //Su buen rollo indica una ganancia de niveles superior a 1.
        monstruos_validos.clear();
        int tama = monstruos.size();
        Monster monstruo_local;
        
        for(int i= 0; tama > i; i++){ //Recorremos el vector
            monstruo_local= monstruos.get(i);
            if(monstruo_local.GetPrize().get_levels() > 1) //Los monstruos que tengan perdida de nivel
                monstruos_validos.add( monstruos.get(i) );

        }
        return monstruos_validos;
    }
    public static ArrayList PerdidaDeTesoro (TreasureKind tesoro_perdido, boolean oculto){
        monstruos_validos.clear();
        int tama = monstruos.size();
        Monster monstruo_local;
        boolean no_encontrado;
        
        for(int i= 0; tama > i; i++){ //Recorremos el vector
            no_encontrado = true;               
            monstruo_local= monstruos.get(i);   //Load the monster
            
            if(oculto){
                if(monstruo_local.Getbc().GetSpecificHiddenTreasures().size() > 0){ //Check hidden treasures
                    for(int j = 0; j < monstruo_local.Getbc().GetSpecificHiddenTreasures().size() && no_encontrado; j++){
                        if(tesoro_perdido == monstruo_local.Getbc().GetSpecificHiddenTreasures().get(j)){ //Check treasure
                            monstruos_validos.add(monstruo_local);
                            no_encontrado = false;
                        }
                    }
                }
            }
            else{
                if(monstruo_local.Getbc().GetSpecificVisibleTreasures().size() > 0 && no_encontrado){ //Check visible treasures
                    for(int j = 0; j < monstruo_local.Getbc().GetSpecificVisibleTreasures().size() && no_encontrado; j++){
                        if(tesoro_perdido == monstruo_local.Getbc().GetSpecificVisibleTreasures().get(j)){ //hacer comprobaciones segun el tesoro
                            monstruos_validos.add(monstruo_local);
                            no_encontrado = false;
                        }
                    }
                }    
            }        
        }
        return monstruos_validos;   
        
    }
    
    
public static void main(String[] args) {

            
        CreaMonstruos();
        monstruos_a_imprimir.clear();
        monstruos_a_imprimir = NivelMayorA(10);
        System.out.println("Los monstruos con nivel de combate superior a 10 son: ");
        for(int i = 0; i < monstruos_a_imprimir.size(); i++){
            System.out.println(monstruos_a_imprimir.get(i).GetName());
        }
        
        monstruos_a_imprimir.clear();
        monstruos_a_imprimir = PerdidaNivelBc();
        System.out.println("\nLos monstruos cuyo mal rollo implica perdida de niveles son: ");
        for(int i = 0; i < monstruos_a_imprimir.size(); i++){
            System.out.println(monstruos_a_imprimir.get(i).GetName());
        }

        monstruos_a_imprimir.clear();
        monstruos_a_imprimir = GananciaLvLMas1();
        System.out.println("\nLos monstruos cuyo buen rollo implica ganancia de niveles superior a 1 son: ");
        for(int i = 0; i < monstruos_a_imprimir.size(); i++){
            System.out.println(monstruos_a_imprimir.get(i).GetName());
        }
        
        TreasureKind tesoro = TreasureKind.ARMOR;
            
        monstruos_a_imprimir.clear();
        monstruos_a_imprimir = PerdidaDeTesoro(tesoro, false);
        System.out.println("\nLos monstruos con perdida de armadura oculta son : ");
        for(int i = 0; i < monstruos_a_imprimir.size(); i++){
            System.out.println(monstruos_a_imprimir.get(i).GetName());
        }
}
    
    
    
}
