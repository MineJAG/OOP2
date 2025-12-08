/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Characters.Player;

/**
 *
 * @author ajone
 */
public class ExitCommand implements Commands {
    public static final String[] COMMAND_NAMES = {"exit", "sair", "quit", "fechar", "close", "terminar", "end", "finalizar"};    

    public static String[] getCOMMAND_NAMES() {
        return COMMAND_NAMES;
    }
    public void execute(Player player) {
        System.out.println("A sair do jogo. Até à próxima!");
        System.exit(0);
    }
    public static String[] getCommandNames() {
        return COMMAND_NAMES;
    }
    
}
