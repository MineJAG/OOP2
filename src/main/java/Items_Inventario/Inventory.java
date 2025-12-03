/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;
import java.util.*;

/**
 *
 * @author ajone
 */
public class Inventory {
    private List<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public Inventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    //conseguir o indice por nome
    private int getIndexName(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    //conseguir o item pelo indice
    public Item getItemIndex(int index) {
        return inventory.get(index);
    }

    public int getSize() {
        return inventory.size();
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
        int index = getIndexName(name);
        if (index != -1) {
            inventory.remove(index);
        }
    }

    //usado
    public Item getItem(String name) {
        int index = getIndexName(name);
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

    public List<Item> getInventory() {
        return inventory;
    }    

    public List<Item> getClues() {
        List<Item> clues = new ArrayList<>();
        for (Item item : inventory) {
            if (item instanceof Clues) {
                clues.add(item);
            }
        }
        return clues;
    }

    public List<Item> getUsables() {
        List<Item> usables = new ArrayList<>();
        for (Item item : inventory) {
            if (item instanceof UsableItem) {
                usables.add(item);
            }
        }
        return usables;
    }
}
