/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Characters;

import java.util.ArrayList;

import Items_Inventario.Inventory;
import Rooms.Sala;

/**
 *
 * @author ajone
 */
public class Player extends Character {
    private Inventory inventory = new Inventory();
    private ArrayList<String> itemHistory = new ArrayList<>();

    public Player(String name, Sala presentRoom){
        super(name, presentRoom);
    }
    
    public Inventory getInventory(){
        return inventory;
    }
    
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public ArrayList<String> getItemHistory() {
        return itemHistory;
    }
    
    public void addItemHistory(String history){
        itemHistory.add(history);
    }
    public void itemHistoryCheck(){
        for (String item : itemHistory) {
            System.out.println(item);
        }
    }
}
