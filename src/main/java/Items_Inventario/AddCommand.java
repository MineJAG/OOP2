/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;
import Characters.*;
/**
 * Classe responsável por adicionar items ao inventário
 * @author Lara
 */
public class AddCommand {
    public void addOne(Player player, Item item) {
        Inventory rInventory = player.getPresentRoom().getInventory();
        if (rInventory.itemInInventory(item)) {
            rInventory.removeItem(item);
            player.getInventory().addItem(item);
            System.out.println("O item " + item.getName() + " foi adicionado ao inventário.");
        }
    }

    public void addMany(Player player, Inventory inventory) {
        if (!inventory.isEmpty()) {
            player.getInventory().addInventory(inventory);
            System.out.println("Os items foram adicionados ao inventário.");
        }
    }
}
