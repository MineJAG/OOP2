/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2;

/**
 *
 * @author ajone
 */
public class LookCommand implements Comands {
    public static final String[] COMMAND_NAMES = {"look", "olhar", "olha", "vision", "visualizar", "visualize", "visionar", "ver", "ve"};

    public LookCommand() {
    }

    public boolean verifyName(String name) {
        for (String commandName : COMMAND_NAMES) {
            if (commandName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void execute(Player player) {
        Sala room = player.getPresentRoom();
        Inventory inventory = room.getInventory();
        System.out.println("O Sherlock observa a sala " + room.getName());
        System.out.println(room.getDescription());
        System.out.println(inventory.toString());
    }
}
