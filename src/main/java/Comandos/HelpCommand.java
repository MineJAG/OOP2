/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.ArrayList;

import Characters.Player;
//import jdk.jshell.Diag;

/**
 * Comando que mostra todos os comandos disponiveis no jogo bem como simples ajuda a como utilizar os mesmos.
 * @author Afonso
 */
public class HelpCommand implements Command{
    private String name = "Help Command - shows all commmands";
    public static final String[] COMMAND_NAMES = {"ajuda", "help"};
    private ArrayList<Command> commmands;

    public HelpCommand(ArrayList<Command> commmands) {
        this.commmands = commmands;
    }

    @Override
    public String[] names(){
        return COMMAND_NAMES;
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public void execute(Player player, ArrayList<String> words){
        for(Command command : commmands){
            System.out.println(command.toString());
        }
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
