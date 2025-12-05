/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Characters.Player;

/**
 *
 * @author Bibby
 */
public class CluesCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"pistas", "clues", "pista", "clue"};
    
    public void execute(Player player) {
        System.out.println("Pistas: \n" + player.getInventory().getClues().toString());        
    }
}

