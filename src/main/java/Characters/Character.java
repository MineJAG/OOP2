/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;

import Items_Inventario.Inventory;
import Rooms.Sala;

/**
 *Classe abstrata que representa uma personagem no jogo.
 * @author Afonso, Tiago
 */
public abstract class Character {
    private String name;
    private Sala presentRoom;
    private Inventory inventory;
    public Character(String name, Inventory inventory, Sala presentRoom){
        this.name = name;
        this.inventory = inventory;
        this.presentRoom = presentRoom;
    }
    
    public String getName(){
        return name;
    }
    
    public Sala getPresentRoom(){
        return presentRoom;
    }
    
    public Sala setPresentRoom(Sala newSala){
        return this.presentRoom = newSala;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
            
}
