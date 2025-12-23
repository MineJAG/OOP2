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
    ArrayList<Command> commands;
    List<Npc> npcs;


    
    public CommandRunner(List<Npc> npcs, ArrayList<Command> commands) {
        this.npcs = npcs;
        this.commands = commands;
        //this.dialogueLoaderCommand = new DialogueLoaderCommand(npcs);
    }

    private ArrayList<String> separate(String userInput) {
        String x = "";
        ArrayList<String> words = new ArrayList<>();

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
        return words;
    }

    public void runCommands(Player player, String userInput) {
        ArrayList<String> words = separate(userInput);

        try {
            if (words.isEmpty()) {
                throw new Exception("Tem de escrever um comando.");
            }

            for (Command c : commands) {
                if (c.matches(words)) {
                    c.execute(player, words);
                    return;
                }
            }

            throw new Exception("Comando desconhecido.");
            
            /*
            if (verifyCommand(InspectCommand.COMMAND_NAMES)) {
                if (inspectCommand.hasObject(player, words)) {
                    inspectCommand.execute(player);
                } else {
                    throw new Exception("Não existe nenhum objeto com esse nome. Tente escrever comando objeto.");
                }
            } else if (verifyCommand(GoCommand.COMMAND_NAMES)){
                if (!goCommand.coorrectDirection(player, words)) {
                    throw new Exception("Não existe nenhuma direção com esse nome. Tente escrever comando direção.");
                } else if (!goCommand.canGo(player)) {
                    throw new Exception("Não posso ir nessa direção.");
                } else if (goCommand.canGo(player)) {
                    goCommand.execute(player);
                }
            } else if (verifyCommand(ExitCommand.COMMAND_NAMES)) {
                    exitcommand.execute(player);
            } else if (verifyCommand(LookCommand.COMMAND_NAMES)) {
                lookCommand.execute(player);
            } else if (verifyCommand(CluesCommand.COMMAND_NAMES)) {
                cluesCommand.execute(player);
            } else if (verifyCommand(UsableItemsCommand.COMMAND_NAMES)) {
                usableItemsCommand.execute(player);
            } else if (verifyCommand(UseCommand.COMMAND_NAMES)) {
                useCommand.hasObject(player, words);
                useCommand.execute(player);
            } else if (verifyCommand(TalkCommand.COMMAND_NAMES)) {
                talkCommand.talkToNpc(npcs, words, player, manager);
                talkCommand.execute(player);
            } else if (verifyCommand(DialogueLoaderCommand.COMMAND_NAMES)){
                dialogueLoaderCommand.setFilepath(words);
                dialogueLoaderCommand.execute(player);
            } else if (verifyCommand(HelpCommand.COMMAND_NAMES)) {
                helpCommand.execute(player);
            } else if (verifyCommand(ExitCommand.COMMAND_NAMES)) {
                exitcommand.execute(player);
            }
            else {
                throw new Exception("Comando inválido.");
            }
                */
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        words.clear();
    }
}
