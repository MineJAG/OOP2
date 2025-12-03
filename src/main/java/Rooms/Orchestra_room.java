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
public class Orchestra_room extends Sala{
    public Orchestra_room(String name, String description, Sala directionN, Sala directionS, Sala directionE, Sala directionW, Inventory roomInventory, java.util.List<Item> roomItens) {
        super("Sala de Orquestra", description, directionN, directionS, directionE, directionW, roomInventory, roomItens);    
    }
    
}
