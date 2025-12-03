/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Items_Inventario.Inventory;
import Rooms.Sala;
import Characters.Player;

/**
 *
 * @author ajone
 */
public class LookCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"look", "olhar", "olha", "vision", "visualizar", "visualize", "visionar", "ver", "ve"};

    public void execute(Player player) {
        Sala room = player.getPresentRoom();
        Inventory inventory = room.getInventory();
        System.out.println("O Sherlock observa a sala " + room.getName());
        System.out.println(room.getDescription());
        System.out.println(inventory.toString());
    }
}
