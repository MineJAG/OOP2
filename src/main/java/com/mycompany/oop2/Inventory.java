/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;
import java.util.*;

/**
 *
 * @author ajone
 */
public class Inventory {
    private List<Item> inventory;
    /*    String type;

    public Inventory(boolean isUsable, String type) {
        inventory = new ArrayList<>();
        this.type = type;
    }
        */

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public Inventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    private int getIndexItem(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(Item item) {
        if (!(item instanceof ImmovabelItem)) {
            inventory.add(item);
        }
    }    

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void removeItem(String name) {
        int index = getIndexItem(name);
        if (index != -1) {
            inventory.remove(index);
        }
    }

    public Item getItem(String name) {
        int index = getIndexItem(name);
        if (index != -1) {
            return inventory.get(index);
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "Inventário: \n";
        for (Item item : inventory) {
            result += "- " + item.getName() + "\n";
        }
        return result;
    }
    
    
}
