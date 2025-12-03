/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Items_Inventario.Inventory;
import Rooms.Sala;
import Comandos.Comands;
import Characters.Player;

/**
 *
 * @author ajone
 */
public class LookCommand implements Comands {
    public static final String[] COMMAND_NAMES = {"look", "olhar", "olha", "vision", "visualizar", "visualize", "visionar", "ver", "ve"};

    private boolean verifyCommand(String userInput) {
        for (String commandName : COMMAND_NAMES) {
            if (commandName.equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public void execute(Player player, String userInput) {
        if (!verifyCommand(userInput)) {
            return;
        }
        Sala room = player.getPresentRoom();
        Inventory inventory = room.getInventory();
        System.out.println("O Sherlock observa a sala " + room.getName());
        System.out.println(room.getDescription());
        System.out.println(inventory.toString());
    }
}
