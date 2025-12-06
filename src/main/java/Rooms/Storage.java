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
public class Storage extends Sala{
    public Storage(Sala directionN, Sala directionS, Sala directionE, Sala directionW) {
        super("Depósito", 
            "", 
            directionN, 
            directionS, 
            directionE, 
            directionW, 
            new Inventory(), 
            new ArrayList<Npc>());
    }
}
