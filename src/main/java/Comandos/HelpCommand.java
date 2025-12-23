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
    public String[] names(){
        return COMMAND_NAMES;
    }

    public String getName(){
        return name;
    }

    public void execute(Player player, ArrayList<String> words) throws Exception{

    }
}
