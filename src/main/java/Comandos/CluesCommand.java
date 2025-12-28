/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.ArrayList;

import Characters.Player;

/**
 * Classe que representa o comando de pistas no jogo tem como responsabilidade imprimir o inventario de pistas do jogo.
 * @author Lara
 */
public class CluesCommand implements Command {
    private String name = "clues command -- Opens the collected clues";
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

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        String result = getName() + "\n Command names: \n\t-";
        result += COMMAND_NAMES[0];
        for(int i = 1; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        return result;
    }
}

