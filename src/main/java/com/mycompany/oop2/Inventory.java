/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ajone
 */
public class Inventory {
    List<Item> inventario;
    /*    String type;

    public Inventory(boolean isUsable, String type) {
        inventario = new ArrayList<>();
        this.type = type;
    }
        */

    public Inventory() {
        inventario = new ArrayList<>();
    }

    public Inventory(List<Item> inventario) {
        this.inventario = inventario;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    private int getIndexItem(String name) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(Item item) {
        if (!(item instanceof ImmovabelItem)) {
            inventario.add(item);
        }
    }    

    public void removeItem(Item item) {
        inventario.remove(item);
    }

    public void removeItem(String name) {
        int index = getIndexItem(name);
        if (index != -1) {
            inventario.remove(index);
        }
    }

    public Item getItem(String name) {
        int index = getIndexItem(name);
        if (index != -1) {
            return inventario.get(index);
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "Inventário: \n";
        for (Item item : inventario) {
            result += "- " + item.getName() + "\n";
        }
        return result;
    }
    public String toStringClues() {
        String result = "Clues: \n";
        for (Item item : inventario) {
            if (item instanceof Clues){
                result += "- " + item.getName() + "\n";
            }
        }
        return result;
    }
    public String toStringUsableItems() {
        String result = "Usables: \n";
        for (Item item : inventario) {
            if (item instanceof UsableItem){
                result += "- " + item.getName() + "\n";
            }
        }
        return result;
    }
}
