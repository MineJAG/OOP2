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
public class UsableItemsCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"item", "itens", "itens", "usable", "usables", "usaveis"};
    
    public void execute(Player player) {
        System.out.println("Itens usáveis: \n" + player.getInventory().getUsables().toString());        
    }

    public static String[] getCommandNames() {
        return COMMAND_NAMES;
    }
}

