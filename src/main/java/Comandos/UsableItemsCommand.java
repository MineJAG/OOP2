/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Characters.Player;
import java.util.*;

/**
 *
 * @author Bibby
 */
public class UsableItemsCommand implements Command {
    private String name = "Usable Items Command(inventory) - show the usable items in the inventory";
    public static final String[] COMMAND_NAMES = {"item", "itens", "itens", "usable", "usables", "usaveis"};

    public String[] names() {
        return COMMAND_NAMES;
    }
    
    public void execute(Player player, ArrayList<String> words) throws Exception {
        if (player.getInventory().getUsables().isEmpty()) {
            throw new Exception("O inventário não contém nenhum item usável.");
        }
        System.out.println("Itens usáveis: \n" + player.getInventory().getUsables().toString());        
    }
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        String result = getName() + "\n Command names: \n\t";
        for(int i = 0; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        return result;
    }
}

