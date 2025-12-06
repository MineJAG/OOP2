/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import java.util.ArrayList;
import Characters.Npc;
import Items_Inventario.Inventory;


/**
 *
 * @author tiago
 */
public class Main_hall extends Sala{
    public Main_hall(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Sala Principal", 
            "Uma sala num estilo barroco e estravagante, tem uns pilhadores artisticos, mesas decoradas, e janelas com artes\r\n" + 
            "o piso de mármore está molhado e a chuva ecoa lá fora.\r\n" +
            "Os convidados parecem assustados.\r\n" +
            "Um rastro de água leva até à porta norte, está entreaberta...hum?", 
            directionN, 
            directionS, 
            directionE, 
            directionW, 
            new Inventory(), 
            new ArrayList<Npc>());    
    }
    
}
