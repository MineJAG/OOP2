/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;

import Items_Inventario.Inventory;
import Items_Inventario.Item;

/**
 *
 * @author tiago
 */
public class Main_hall extends Sala{
    public Main_hall(String name, String description, Sala directionN, Sala directionS, Sala directionE, Sala directionW, Inventory roomInventory, java.util.List<Item> roomItens) {
        super("Saguão Principal", description, directionN, directionS, directionE, directionW, roomInventory, roomItens);    
    }
    
}
