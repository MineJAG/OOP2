/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items_Inventario;
import Characters.*;
/**
 *
 * @author Bibby
 */
public class AddCommand {
    public void execute(Player player, Item item) {
        Inventory rInventory = player.getPresentRoom().getInventory();
        if (rInventory.itemInInventory(item) && !(item instanceof ImmovabelItem)) {
            rInventory.removeItem(item);
            player.getInventory().addItem(item);
            System.out.println("O item " + item.getName() + " foi adicionado ao inventário.");
        }
    }
}
