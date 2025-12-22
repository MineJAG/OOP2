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
public class CluesCommand implements Command {
    public static final String[] COMMAND_NAMES = {"pistas", "clues", "pista", "clue"};

    public String[] names() {
        return COMMAND_NAMES;
    }

    public void execute(Player player, ArrayList<String> words) throws Exception {
        if (player.getInventory().getClues().isEmpty()) {
            throw new Exception("O inventário não contém nenhuma pista.");
        }
        System.out.println("Pistas: \n" + player.getInventory().getClues().toString());        
    } 
}

