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
public class Office extends Sala{
    boolean locked;
    public Office(String name, String description, Sala directionN, Sala directionS, Sala directionE, Sala directionW, Inventory roomInventory, ArrayList<Npc> npcs, boolean locked) {
        super(name, description, directionN, directionS, directionE, directionW, roomInventory, npcs);
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setUnlocked() {
        this.locked = false;
    }
    
}
