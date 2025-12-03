/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

/**
 *
 * @author Bibby
 */
public class CluesCommand {
    public static final String[] COMMAND_NAMES = {"clues", "pistas"};

    private boolean verifyCommand(String userInput) {
        for (String commandName : COMMAND_NAMES) {
            if (commandName.equals(userInput)) {
                return true;
            }
        }
        return false;
    }
    
    public void execute(Player player, String userInput) {

        String result = "Clues: \n";
        for (Clues clue : clues) {
            result += "- " + clue.getName() + "\n";
        }
        
    }
}

