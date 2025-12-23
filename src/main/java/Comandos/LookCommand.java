/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Items_Inventario.Inventory;
import Rooms.*;

import java.util.ArrayList;
import java.util.List;

import Characters.Player;

/**
 *
 * @author ajone
 */
public class LookCommand implements Command {
    private String name = "Look Command - see what is arround syntax Look";
    public static final String[] COMMAND_NAMES = {"look", "olhar", "olha", "vision", "visualizar", "visualize", "visionar", "ver", "ve"};

    public String[] names() {
        return COMMAND_NAMES;
    }
    
    public void execute(Player player, ArrayList<String> words) throws Exception{
        Sala room = player.getPresentRoom();
        if (room == null) {
            throw new Exception("O Sherlock não se encontra numa sala.");
        }
        Inventory inventory = room.getInventory();
        System.out.println("O Sherlock observa a/o " + room.getName());
        System.out.println(room.getDescription());
        if(room instanceof Storage) {
            if (!((Storage) room).isLightOn()) {
                return;
            }
        }
        if (inventory == null || inventory.isEmpty()) {
            throw new Exception("Nao ha nada aqui.");
        }
        System.out.println(inventory.toString());
    }
}
