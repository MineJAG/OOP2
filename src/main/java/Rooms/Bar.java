/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;
import Items_Inventario.Inventory;
import java.util.ArrayList;
import Characters.Npc;

/**
 *
 * @author tiago
 */
public class Bar extends Sala {
    public Bar(String name, String description, Sala directionN, Sala directionS, Sala directionE, Sala directionW, Inventory roomInventory, ArrayList<Npc> npcs) {
        super(name, description, directionN, directionS, directionE, directionW, roomInventory, npcs);
    }
}
