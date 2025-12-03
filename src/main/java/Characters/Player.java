/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;

import Items_Inventario.*;
import Rooms.Sala;

/**
 *
 * @author ajone
 */
public class Player extends Character {
    private Inventory inventory = new Inventory();

    public Player(String name, Sala presentRoom){
        super(name, presentRoom);
    }
    
    public Inventory getInventory(){
        return inventory;
    }
    
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
}
