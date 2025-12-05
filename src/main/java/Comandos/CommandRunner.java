/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.*;
import Characters.*;

/**
 *
 * @author Bibby
 */
public class CommandRunner {
    List<String> words = new ArrayList<>();
            
    TalkCommand talkCommand = new TalkCommand();
    InspectCommand inspectCommand = new InspectCommand();
    ExitCommand exitCommand = new ExitCommand();
    HelpCommand helpCommand = new HelpCommand();
    DialogueLoaderCommand dialogueLoaderCommand = new DialogueLoaderCommand();
    CluesCommand cluesCommand = new CluesCommand();
    UsableItemsCommand usableItemsCommand = new UsableItemsCommand();
    LookCommand lookCommand = new LookCommand();
    
    private void separate(String userInput) {
        String x = "";

        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?') {
                if (!x.isEmpty()) {
                    words.add(x);
                    x = "";
                }
            } else {
                x += c;
            }
        }
        if (!x.isEmpty()) {
            words.add(x);
        }
}

    private boolean verifyCommand(String[] commandNames) {
        for (String word : words) {
            for (String commandName : commandNames) {
                if (commandName.equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* so usar quando todos os comandos tiverem acabados
    private boolean verifyAllCommands() {
        return verifyCommand(LookCommand.COMMAND_NAMES) ||
                verifyCommand(InspectCommand.COMMAND_NAMES) ||
                verifyCommand(TalkCommand.COMMAND_NAMES) ||
                verifyCommand(ExitCommand.COMMAND_NAMES) ||
                verifyCommand(HelpCommand.COMMAND_NAMES) ||
                verifyCommand(DialogueLoaderCommand.COMMAND_NAMES) ||
                verifyCommand(CluesCommand.COMMAND_NAMES) ||
                verifyCommand(UsableItemsCommand.COMMAND_NAMES);
    }
                */
    private boolean verifyAllCommands() {
        return verifyCommand(LookCommand.COMMAND_NAMES) ||
                verifyCommand(InspectCommand.COMMAND_NAMES) ||
                verifyCommand(CluesCommand.COMMAND_NAMES) ||
                verifyCommand(UsableItemsCommand.COMMAND_NAMES);
    }


    public void runCommands(Player player, String userInput) {
        separate(userInput);

        try {
            if (words.isEmpty()) {
                throw new Exception("Tem de escrever um comando.");
            }
            if (!verifyAllCommands()) {
                throw new Exception("Comando inválido.");
            }
            if (verifyCommand(InspectCommand.COMMAND_NAMES)) {
                if (inspectCommand.hasObject(player, words)) {
                    inspectCommand.execute(player);
                } else {
                    throw new Exception("Não existe nenhum objeto com esse nome. Tente escrever comando objeto.");
                }
            } else if (verifyCommand(LookCommand.COMMAND_NAMES)) {
                lookCommand.execute(player);
            } else if (verifyCommand(CluesCommand.COMMAND_NAMES)) {
                cluesCommand.execute(player);
            } else if (verifyCommand(UsableItemsCommand.COMMAND_NAMES)) {
                usableItemsCommand.execute(player);
            } 
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        words.clear();
    }
}
