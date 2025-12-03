/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Items_Inventario.Inventory;
import Items_Inventario.Item;
import Items_Inventario.UsableItem;
import java.util.ArrayList;
import java.util.List;

import Characters.Player;
import Items_Inventario.*;

/**
 *
 * @author Bibby
 */
public class UsableItemsCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"item", "itens", "itens", "usable", "usables", "usaveis"};
    
    public void execute(Player player) {
        Inventory inventory = player.getInventory();
        String result = "Clues: \n";
        for (Item item : inventory.getUsables()) {
            result += "- " + item.getName() + "\n";
        }
        System.out.println(result);
        
        
    }
}

