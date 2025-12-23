/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Characters.Player;
import java.util.ArrayList;
//import jdk.jshell.Diag;

/**
 *
 * @author ajone
 */
public class HelpCommand{
    private String name = "Help Command - shows all commands";
    public static final String[] COMMAND_NAMES = {"ajuda", "help"};
    private ArrayList<Command> commands;

    public HelpCommand(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public String[] names(){
        return COMMAND_NAMES;
    }

    public String getName(){
        return name;
    }
    
    public void execute(Player player, ArrayList<String> words){
        for(Command command : commands){
            System.out.println(command.toString());
        }
    }

    public String toString() {
        String result = getName() + "\n Command names: \n\t-";
        for(int i = 0; i < COMMAND_NAMES.length; i++) {
            result += ", " + COMMAND_NAMES[i];
        }
        return result;
    }
}
