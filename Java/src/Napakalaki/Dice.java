package Napakalaki;

public class Dice {
    // SINGLETON
    private static final Dice instance = new Dice();
    
    private Dice() {  }
    
    public static Dice getInstance() {
        return instance;
    }
    
    public int nextNumber(){
        int numeroAleatorio = (int) ( Math.random() * 6 + 1 );
        return numeroAleatorio;
    }
}