/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.*;
import Characters.*;
import Items_Inventario.*;
import Rooms.Sala;

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
            x+=userInput.charAt(i);
            if (x.equals(" ")|| x.equals(".")|| x.equals(",")|| x.equals("!")|| x.equals("?")) {
                if (x.length() <= 2) {
                    x = "";
                } else {
                    words.add(x);
                    x = "";
                }
            }
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

    private String getObject(Inventory pInventory, Inventory rInventory, List<Npc> npcs, Sala room) {
        for (String word : words) {
            for (Item item : pInventory.getInventory()) {
                if (item.getName().equals(word)) {
                    return item.getName();
                }
            }
            for (Item item : rInventory.getInventory()) {
                if (item.getName().equals(word)) {
                    return item.getName();
                }
            }
            for (Npc npc : npcs) {
                if (npc.getName().equals(word)) {
                    return npc.getName();
                }
            }
            if (room.getName().equals(word)) {
                return room.getName();
            }
        }
        return null;
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
        separate(userInput.toLowerCase());
        Inventory pInventory = player.getInventory();
        Inventory rInventory = player.getPresentRoom().getInventory();
        List<Npc> npcs = player.getPresentRoom().getNpcs();
        Sala room = player.getPresentRoom();

        try {
            if (words.isEmpty()) {
                throw new Exception("Tem de escrever um comando.");
            }
            if (verifyAllCommands()) {
                throw new Exception("Comando inválido.");
            }
            if (verifyCommand(inspectCommand.COMMAND_NAMES) &&
                getObject(pInventory, rInventory, null, room) == null) {
                throw new Exception("Tem de usar um objeto válido. Tente escrever: comando objeto.");
            }

            if (verifyCommand(LookCommand.COMMAND_NAMES)) {
                lookCommand.execute(player);
            } else if (verifyCommand(InspectCommand.COMMAND_NAMES)) {
                inspectCommand.execute(player);
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
