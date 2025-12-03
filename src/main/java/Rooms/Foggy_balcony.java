/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rooms;

import Items_Inventario.Inventory;
import Items_Inventario.Item;
import java.util.List;

/**
 *
 * @author tiago
 */
public class Foggy_balcony extends Sala{
    public Foggy_balcony(String name, String description, Sala directionN, Sala directionS, Sala directionE, Sala directionW, Inventory roomInventory, List<Item> roomItens) {
        super("Varanda Sombria", description, directionN, directionS, directionE, directionW, roomInventory, roomItens);    
    }
    
}
