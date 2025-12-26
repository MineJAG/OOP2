/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import java.util.ArrayList;

import Characters.Player;

/**
 * gere a logica para finalizar a execução do jogo
 * @author tiago
 */
public class ExitCommand implements Command {
    private String name = "Exit Command - Exit the game";
    public static final String[] COMMAND_NAMES = {"exit", "sair", "quit", "fechar", "close", "terminar", "end", "finalizar"};    

    public String[] names() {
        return COMMAND_NAMES;
    }
    
    public void execute(Player player, ArrayList<String> words) throws Exception {
        System.exit(0);
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
