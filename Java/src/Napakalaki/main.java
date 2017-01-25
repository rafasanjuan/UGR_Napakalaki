package Napakalaki;

import GUI.*;
import java.util.ArrayList;

public class main {
    public static void main( String [ ] args )
    {
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        
        GUI.Dice.createInstance( napakalakiView );
        
        // Comenzar el juego leyendo los nombres.
        PlayerNamesCapture namesCapture = new PlayerNamesCapture( napakalakiView, true );
        ArrayList<String> names;
        names = namesCapture.getNames();
        game.initGame( names );
        
        napakalakiView.setNapakalaki( game );
        
        napakalakiView.setVisible( true );
    }
}