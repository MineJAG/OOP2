/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;

import Characters.Character;
import Items_Inventario.InventoryUsableItem;
import Items_Inventario.InventoryClues;
import Rooms.Sala;

/**
 *
 * @author ajone
 */
public class Player extends Character {
    private Sala presentRoom;
    private InventoryClues inventoryClues = new InventoryClues();
    private InventoryUsableItem inventoryUsableItem = new InventoryUsableItem();

    public Player(String name, Sala salaN, Sala presentRoom){
        super(name, salaN);
        this.presentRoom = presentRoom;
    }

    public InventoryClues getInventoryClues() {
        return inventoryClues;
    }

    public void setInventoryClues(InventoryClues inventoryClues) {
        this.inventoryClues = inventoryClues;
    }

    public InventoryUsableItem getInventoryUsableItem() {
        return inventoryUsableItem;
    }

    public void setInventoryUsableItem(InventoryUsableItem inventoryUsableItem) {
        this.inventoryUsableItem = inventoryUsableItem;
    }

    public Sala getPresentRoom(){
        return presentRoom;
    }

    public Sala setPresentRoom(Sala newPresentRoom){
        return this.presentRoom = newPresentRoom;
    }
    
    
    
}
