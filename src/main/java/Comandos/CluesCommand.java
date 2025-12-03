/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Characters.Player;
import Items_Inventario.*;

/**
 *
 * @author Bibby
 */
public class CluesCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"pistas", "clues", "pista", "clue"};
    
    public void execute(Player player) {
        Inventory inventory = player.getInventory();
        String result = "Pistas: \n";
        for (Item item : inventory.getClues()) {
            result += "- " + item.getName() + "\n";
        }
        System.out.println(result);
        
        
    }
}

