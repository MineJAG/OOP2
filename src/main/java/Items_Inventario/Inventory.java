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

    public Inventory getClues() {
        Inventory clues = new Inventory();
        for (Item item : inventory) {
            if (item instanceof Clues) {
                clues.addItem(item);
            }
        }
        return clues;
    }

    public Inventory getUsables() {
        Inventory usables = new Inventory();
        for (Item item : inventory) {
            if (item instanceof UsableItem) {
                usables.addItem(item);
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

    public Inventory copy() {
        return new Inventory(new ArrayList<>(inventory));
    }

    public boolean containsItem(String item) {
        for(int i=0; i<inventory.size(); i++) {
            if(inventory.get(i).getName().equals(item)) {
                return true;
            }
        }
        return false;
    }
}
