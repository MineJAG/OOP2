/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;
import Characters.Player;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class ExitCommand implements Command {
    public static final String[] COMMAND_NAMES = {"exit", "sair", "quit", "fechar", "close", "terminar", "end", "finalizar"};    

    public String[] names() {
        return COMMAND_NAMES;
    }
    
    public void execute(Player player, ArrayList<String> words) throws Exception {
        System.out.println("A sair do jogo. Até à próxima!");
        System.exit(0);
    }
    
}
