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

    //conseguir o item pelo indice
    public Item getItemIndex(int index) {
        return inventory.get(index);
    }

    public int getSize() {
        return inventory.size();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }    

    public void addInventory(Inventory inventory) {
        this.inventory.addAll(inventory.getInventory());
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    //usado
    public Item getItem(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean itemInInventory(Item item) {
        return inventory.contains(item);
    }

    @Override
    public String toString() {
        String result = "";
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

    public int size() {
        return inventory.size();
    }

    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    public void clear() {
        inventory.clear();
    }
}
